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


import com.github.thierrysquirrel.network.annotation.Network;
import com.github.thierrysquirrel.network.constants.NetworkFactoryConstants;
import com.github.thierrysquirrel.network.factory.NetworkFactory;
import com.github.thierrysquirrel.network.override.ScanningComponent;
import lombok.Data;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * ClassName: NetworkAssemble
 * Description:
 * date: 2019/6/10 21:03
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class NetworkAssemble implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {
	private ResourceLoader resourceLoader;

	private Environment environment;

	@Override
	public void setEnvironment(@Nonnull Environment environment) {
		this.environment = environment;
	}


	@Override
	public void setResourceLoader(@Nonnull ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		ClassPathScanningCandidateComponentProvider scanner = new ScanningComponent(Boolean.FALSE, this.environment);
		scanner.setResourceLoader(this.resourceLoader);

		AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(Network.class);
		scanner.addIncludeFilter(annotationTypeFilter);

		String packageName = ClassUtils.getPackageName(importingClassMetadata.getClassName());
		Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(packageName);
		candidateComponents.forEach(beanDefinition -> {
			AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) beanDefinition;
			AnnotationMetadata annotationMetadata = annotatedBeanDefinition.getMetadata();
			BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(NetworkFactory.class);
			String className = annotationMetadata.getClassName();
			definition.addPropertyValue(NetworkFactoryConstants.PROPERTY_VALUE.getValue(), className);
			definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

			AbstractBeanDefinition abstractBeanDefinition = definition.getBeanDefinition();
			BeanDefinitionHolder holder = new BeanDefinitionHolder(abstractBeanDefinition, className);
			BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);

		});

	}

}
