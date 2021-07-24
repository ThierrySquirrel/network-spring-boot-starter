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

package com.github.thierrysquirrel.network.core.http.factory.execution;


import com.github.thierrysquirrel.network.autoconfigure.NetworkProperties;
import com.github.thierrysquirrel.network.core.http.factory.OkHttpClientBuilderFactory;
import com.github.thierrysquirrel.network.core.utils.JsonUtils;
import com.github.thierrysquirrel.network.error.NetworkException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: RequestFactoryExecution
 * Description:
 * date: 2019/6/9 15:31
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class RequestFactoryExecution {
	private RequestFactoryExecution() {
	}

	public static <T> Object execute(NetworkProperties networkProperties, Request request, Class<T> resultType) throws IOException, NetworkException {

		OkHttpClient okHttpClient = OkHttpClientBuilderFactory.createdOkHttp(networkProperties);
		ResponseBody body = okHttpClient.newCall(request).execute().body();
		if (null == body) {
			throw new NetworkException("body is null");
		}
		if (resultType.equals(InputStream.class)) {
			return body.byteStream();
		}

		String result = body.string();
		if (resultType.equals(String.class)) {
			return result;
		}

		return JsonUtils.fromJson(result, resultType);

	}
}
