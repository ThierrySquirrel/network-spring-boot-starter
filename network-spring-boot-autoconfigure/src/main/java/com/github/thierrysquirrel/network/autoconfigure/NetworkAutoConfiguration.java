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

import com.github.thierrysquirrel.network.annotation.EnableNetwork;
import com.github.thierrysquirrel.network.aspect.NetworkAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * ClassName: NetworkAutoConfiguration
 * Description:
 * date: 2019/6/8 20:41
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Configuration
@EnableConfigurationProperties(NetworkProperties.class)
@ConditionalOnBean(annotation = EnableNetwork.class)
@Slf4j
public class NetworkAutoConfiguration {
	@Resource
	private NetworkProperties networkProperties;

	@Bean
	@ConditionalOnMissingBean(NetworkAspect.class)
	public NetworkAspect networkAspect() {
		return new NetworkAspect(networkProperties);
	}
}
