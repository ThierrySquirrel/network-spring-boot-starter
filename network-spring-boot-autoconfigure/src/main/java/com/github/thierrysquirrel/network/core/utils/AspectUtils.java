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

package com.github.thierrysquirrel.network.core.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * ClassName: AspectUtils
 * Description:
 * date: 2019/6/9 15:58
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class AspectUtils {
	private AspectUtils() {
	}

	public static Method getMethod(ProceedingJoinPoint proceedingJoinPoint) {
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		return signature.getMethod();
	}

	public static <T extends Annotation> T getAnnotation(ProceedingJoinPoint proceedingJoinPoint, Class<T> annotationClass) {
		return getMethod(proceedingJoinPoint).getAnnotation(annotationClass);
	}

	public static Parameter[] getParams(ProceedingJoinPoint proceedingJoinPoint) {
		Method method = getMethod(proceedingJoinPoint);
		return method.getParameters();
	}

	public static Class<?> getResultType(ProceedingJoinPoint proceedingJoinPoint) {
		return getMethod(proceedingJoinPoint).getReturnType();
	}


}
