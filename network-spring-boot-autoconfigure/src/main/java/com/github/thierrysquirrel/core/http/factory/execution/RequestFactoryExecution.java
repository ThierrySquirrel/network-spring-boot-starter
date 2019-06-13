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

package com.github.thierrysquirrel.core.http.factory.execution;


import com.github.thierrysquirrel.core.utils.JsonUtils;
import org.apache.http.client.fluent.Request;

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

	public static <T> Object execute(Request request, Class<T> resultType) throws IOException {

		if (resultType.equals(InputStream.class)) {
			return request.execute().returnContent().asStream();
		}

		String result = request.execute().returnContent().asString();

		if (resultType.equals(String.class)) {
			return result;
		}

		return JsonUtils.fromJson(result, resultType);

	}
}
