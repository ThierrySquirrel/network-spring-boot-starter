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


import com.github.thierrysquirrel.network.constants.RequestConstants;
import com.github.thierrysquirrel.network.core.http.builder.UniformResourceLocatorBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: UniformResourceLocatorBuilderFactory
 * Description:
 * date: 2019/6/9 22:09
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class UniformResourceLocatorBuilderFactory {
	private UniformResourceLocatorBuilderFactory() {
	}

	public static <T> UniformResourceLocatorBuilder create(T annotation) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method method = annotation.getClass().getMethod(RequestConstants.VALUE.getValue());
		Object url = method.invoke(annotation);
		return new UniformResourceLocatorBuilder(url.toString());
	}
}
