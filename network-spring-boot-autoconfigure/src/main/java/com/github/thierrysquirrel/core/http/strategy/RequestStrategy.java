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


import com.github.thierrysquirrel.annotation.DeleteRequest;
import com.github.thierrysquirrel.annotation.GetRequest;
import com.github.thierrysquirrel.annotation.PostRequest;
import com.github.thierrysquirrel.annotation.PutRequest;
import com.github.thierrysquirrel.error.NetworkException;
import org.apache.http.client.fluent.Request;

import java.net.URI;

/**
 * ClassName: RequestStrategy
 * Description:
 * date: 2019/6/9 21:31
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class RequestStrategy {
	private RequestStrategy() {
	}

	public static <T> Request createRequest(T annotation, URI url) throws NetworkException {
		if (annotation instanceof GetRequest) {
			return Request.Get(url);
		}
		if (annotation instanceof PostRequest) {
			return Request.Post(url);
		}
		if (annotation instanceof PutRequest) {
			return Request.Put(url);
		}
		if (annotation instanceof DeleteRequest) {
			return Request.Delete(url);
		}
		throw new NetworkException("Annotations do not exist");
	}
}
