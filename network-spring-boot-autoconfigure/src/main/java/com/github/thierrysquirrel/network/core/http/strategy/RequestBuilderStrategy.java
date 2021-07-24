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

package com.github.thierrysquirrel.network.core.http.strategy;


import com.github.thierrysquirrel.network.annotation.NetworkBody;
import com.github.thierrysquirrel.network.annotation.NetworkFile;
import com.github.thierrysquirrel.network.annotation.NetworkHeader;
import com.github.thierrysquirrel.network.annotation.NetworkParam;
import com.github.thierrysquirrel.network.core.domain.BodyDomain;
import com.github.thierrysquirrel.network.core.http.builder.UniformResourceLocatorBuilder;
import com.github.thierrysquirrel.network.core.utils.JsonUtils;
import com.github.thierrysquirrel.network.core.utils.ObjectIsEmptyUtils;

import java.io.File;
import java.lang.reflect.Parameter;
import java.util.Map;

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

	public static void builder(UniformResourceLocatorBuilder uriBuilder, Map<String, String> headers, Map<String, File> fileMap, BodyDomain bodyDomain, Parameter parameter, Object arg) {
		NetworkParam networkParam = parameter.getAnnotation(NetworkParam.class);
		if (ObjectIsEmptyUtils.isNotEmpty(networkParam)) {
			uriBuilder.setParameter(networkParam.value(), arg.toString());
			return;
		}
		NetworkHeader networkHeader = parameter.getAnnotation(NetworkHeader.class);
		if (ObjectIsEmptyUtils.isNotEmpty(networkHeader)) {
			headers.put(networkHeader.value(), arg.toString());
			return;
		}
		NetworkFile networkFile = parameter.getAnnotation(NetworkFile.class);
		if (ObjectIsEmptyUtils.isNotEmpty(networkFile)) {
			fileMap.put(networkFile.value(), (File) arg);
			return;
		}
		NetworkBody networkBody = parameter.getAnnotation(NetworkBody.class);
		if (ObjectIsEmptyUtils.isNotEmpty(networkBody)) {
			bodyDomain.setBody(JsonUtils.toJson(arg));
		}

	}
}
