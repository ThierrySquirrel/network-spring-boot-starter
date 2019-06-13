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

package com.github.thierrysquirrel.core.http.factory;


import com.github.thierrysquirrel.autoconfigure.NetworkProperties;
import com.github.thierrysquirrel.core.http.builder.RequestBuilder;
import com.github.thierrysquirrel.core.http.strategy.RequestStrategy;
import com.github.thierrysquirrel.error.NetworkException;
import org.apache.http.client.fluent.Request;

import java.io.File;
import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: RequestBuilderFactory
 * Description:
 * date: 2019/6/9 21:23
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class RequestBuilderFactory {

	public static <T> Request createRequest(T annotation, URI url, Map<String, String> headers, Map<String, File> bodyFile, Set<String> bodySet, NetworkProperties networkProperties) throws NetworkException {
		Request request = RequestStrategy.createRequest(annotation, url);
		RequestBuilder requestBuilder = new RequestBuilder(request);
		requestBuilder.setHeaders(headers);
		requestBuilder.setBodyFile(bodyFile);
		requestBuilder.setBody(bodySet);
		requestBuilder.setTimeout(networkProperties);
		return requestBuilder.builder();
	}
}
