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

package com.github.thierrysquirrel.network.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: NetworkProperties
 * Description:
 * date: 2019/6/8 20:39
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
@ConfigurationProperties(prefix = NetworkProperties.NETWORK_PREFIX)
public class NetworkProperties {
	public static final String NETWORK_PREFIX = "thierrysquirrel";
	private Integer connectTimeout = 1000;
	private Integer readTimeout = 1000;
	private Integer writeTimeout = 1000;

}
