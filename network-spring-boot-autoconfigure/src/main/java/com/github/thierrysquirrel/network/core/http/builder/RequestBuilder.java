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

package com.github.thierrysquirrel.network.core.http.builder;


import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;

/**
 * ClassName: RequestBuilder
 * Description:
 * date: 2019/6/8 21:03
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class RequestBuilder {
	private RequestBuilder() {
	}

	public static void builderUrl(Request.Builder builder, String url) {
		builder.url(url);
	}

	public static void builderHeaders(Request.Builder builder, Map<String, String> map) {
		map.forEach(builder::addHeader);
	}

	public static void builderGet(Request.Builder builder) {
		builder.get();
	}

	public static void builderPut(Request.Builder builder, RequestBody requestBody) {
		builder.put(requestBody);
	}

	public static void builderPost(Request.Builder builder, RequestBody requestBody) {
		builder.post(requestBody);
	}

	public static void builderDelete(Request.Builder builder, RequestBody requestBody) {
		builder.delete(requestBody);
	}
}
