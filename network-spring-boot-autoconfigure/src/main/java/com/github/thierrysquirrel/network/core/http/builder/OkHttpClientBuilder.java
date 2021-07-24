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

import com.github.thierrysquirrel.network.autoconfigure.NetworkProperties;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: OkHttpClientBuilder
 * Description:
 * date: 2019/12/19 15:33
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class OkHttpClientBuilder {
	private OkHttpClientBuilder() {
	}

	public static void builderTimeout(OkHttpClient.Builder builder, NetworkProperties networkProperties) {
		builder.connectTimeout(networkProperties.getConnectTimeout(), TimeUnit.MILLISECONDS);
		builder.readTimeout(networkProperties.getReadTimeout(), TimeUnit.MILLISECONDS);
		builder.writeTimeout(networkProperties.getWriteTimeout(), TimeUnit.MILLISECONDS);
	}
}
