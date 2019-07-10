/**
 * Copyright 2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.thierrysquirrel.core.http.strategy;


import com.github.thierrysquirrel.annotation.NetworkBody;
import com.github.thierrysquirrel.annotation.NetworkFile;
import com.github.thierrysquirrel.annotation.NetworkHeader;
import com.github.thierrysquirrel.annotation.NetworkParam;
import com.github.thierrysquirrel.core.utils.JsonUtils;
import com.github.thierrysquirrel.core.utils.ObjectUtils;
import org.apache.http.client.utils.URIBuilder;

import java.io.File;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: RequestBuilderStrategy
 * Description:
 * date: 2019/6/9 17:01
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class RequestBuilderStrategy {
	private RequestBuilderStrategy() {
	}

	public static void builder(URIBuilder uriBuilder, Map<String, String> headers, Map<String, File> bodyFile, Set<String> bodySet, Parameter parameter, Object arg) {

		NetworkParam networkParam = parameter.getAnnotation(NetworkParam.class);
		if (ObjectUtils.isNotEmpty(networkParam)) {
			uriBuilder.setParameter(networkParam.value(), arg.toString());
			return;
		}
		NetworkHeader networkHeader = parameter.getAnnotation(NetworkHeader.class);
		if (ObjectUtils.isNotEmpty(networkHeader)) {
			headers.put(networkHeader.value(), arg.toString());
			return;
		}
		NetworkFile networkFile = parameter.getAnnotation(NetworkFile.class);
		if (ObjectUtils.isNotEmpty(networkFile)) {
			bodyFile.put(networkFile.value(), (File) arg);
			return;
		}
		NetworkBody networkBody = parameter.getAnnotation(NetworkBody.class);
		if (ObjectUtils.isNotEmpty(networkBody)) {
			bodySet.add(JsonUtils.toJson(arg));
		}

	}
}
