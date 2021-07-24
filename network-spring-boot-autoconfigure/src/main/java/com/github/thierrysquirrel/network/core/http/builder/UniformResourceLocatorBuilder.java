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

import com.github.thierrysquirrel.network.constants.UniformResourceLocatorBuilderConstants;

/**
 * ClassName: UniformResourceLocatorBuilder
 * Description:
 * date: 2019/12/19 15:43
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class UniformResourceLocatorBuilder {
	private String url;
	private StringBuilder urlBuilder;

	public UniformResourceLocatorBuilder(String url) {
		this.url = url;
	}

	public UniformResourceLocatorBuilder setParameter(String param, String value) {
		if (urlBuilder == null) {
			urlBuilder = new StringBuilder(url);
			urlBuilder.append(UniformResourceLocatorBuilderConstants.FIRST_CONNECTOR.getValue());
		} else {
			urlBuilder.append(UniformResourceLocatorBuilderConstants.CONNECTOR.getValue());
		}
		urlBuilder.append(param);
		urlBuilder.append(UniformResourceLocatorBuilderConstants.LINK.getValue());
		urlBuilder.append(value);
		return this;
	}

	public String builder() {
		if (urlBuilder == null) {
			return url;
		}
		return urlBuilder.toString();
	}
}
