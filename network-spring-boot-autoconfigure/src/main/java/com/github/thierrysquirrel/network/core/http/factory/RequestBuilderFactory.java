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

package com.github.thierrysquirrel.network.core.http.factory;


import com.github.thierrysquirrel.network.core.http.builder.RequestBuilder;
import com.github.thierrysquirrel.network.core.http.strategy.RequestStrategy;
import com.github.thierrysquirrel.network.error.NetworkException;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.File;
import java.util.Map;

/**
 * ClassName: RequestBuilderFactory
 * Description:
 * date: 2019/6/9 21:23
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class RequestBuilderFactory {
	private RequestBuilderFactory() {
	}

	public static <T> Request createRequest(T annotation, String url, Map<String, String> headers, Map<String, File> fileMap, String body) throws NetworkException {
		Request.Builder builder = new Request.Builder();
		RequestBuilder.builderUrl(builder, url);
		RequestBuilder.builderHeaders(builder, headers);

		RequestBody requestBody = RequestBodyBuilderFactory.createdMultipartBody(fileMap, body);

		return RequestStrategy.createRequest(annotation, builder, requestBody);
	}
}
