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

package com.github.thierrysquirrel.network.factory;


import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * ClassName: NetworkFactory
 * Description:
 * date: 2019/6/10 21:25
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class NetworkFactory implements FactoryBean<Object> {
	private Class<?> type;

	@Override
	public Object getObject() {
		return NetworkProxyFactory.createInstance(type);
	}

	@Override
	public Class<?> getObjectType() {
		return type;
	}
}
