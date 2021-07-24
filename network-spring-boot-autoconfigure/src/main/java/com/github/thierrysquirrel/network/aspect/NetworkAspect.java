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

package com.github.thierrysquirrel.network.aspect;


import com.github.thierrysquirrel.network.annotation.DeleteRequest;
import com.github.thierrysquirrel.network.annotation.GetRequest;
import com.github.thierrysquirrel.network.annotation.PostRequest;
import com.github.thierrysquirrel.network.annotation.PutRequest;
import com.github.thierrysquirrel.network.autoconfigure.NetworkProperties;
import com.github.thierrysquirrel.network.core.utils.AspectUtils;
import com.github.thierrysquirrel.network.intercept.InterceptRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ClassName: NetworkAspect
 * Description:
 * date: 2019/6/9 15:52
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Aspect
@Slf4j
@Data
public class NetworkAspect {
	private NetworkProperties networkProperties;

	public NetworkAspect(NetworkProperties networkProperties) {
		this.networkProperties = networkProperties;
	}


	@Pointcut("@annotation(com.github.thierrysquirrel.network.annotation.GetRequest)")
	public void getRequestAspect() {
		log.debug("Start agency GetRequest");
	}

	@Pointcut("@annotation(com.github.thierrysquirrel.network.annotation.PostRequest)")
	public void postRequestAspect() {
		log.debug("Start agency PostRequest");
	}

	@Pointcut("@annotation(com.github.thierrysquirrel.network.annotation.PutRequest)")
	public void putRequestAspect() {
		log.debug("Start agency PutRequest");
	}

	@Pointcut("@annotation(com.github.thierrysquirrel.network.annotation.DeleteRequest)")
	public void deleteRequestAspect() {
		log.debug("Start agency PutRequest");
	}

	@Around("getRequestAspect() ")
	public Object getRequestAgent(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
		return InterceptRequest.intercept(networkProperties, proceedingJoinPoint.getArgs(), AspectUtils.getParams(proceedingJoinPoint), AspectUtils.getAnnotation(proceedingJoinPoint, GetRequest.class), AspectUtils.getResultType(proceedingJoinPoint));
	}

	@Around("postRequestAspect()")
	public Object postRequestAgent(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
		return InterceptRequest.intercept(networkProperties, proceedingJoinPoint.getArgs(), AspectUtils.getParams(proceedingJoinPoint), AspectUtils.getAnnotation(proceedingJoinPoint, PostRequest.class), AspectUtils.getResultType(proceedingJoinPoint));
	}

	@Around("putRequestAspect()")
	public Object putRequestAgent(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
		return InterceptRequest.intercept(networkProperties, proceedingJoinPoint.getArgs(), AspectUtils.getParams(proceedingJoinPoint), AspectUtils.getAnnotation(proceedingJoinPoint, PutRequest.class), AspectUtils.getResultType(proceedingJoinPoint));
	}

	@Around("deleteRequestAspect()")
	public Object deleteRequestAgent(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
		return InterceptRequest.intercept(networkProperties, proceedingJoinPoint.getArgs(), AspectUtils.getParams(proceedingJoinPoint), AspectUtils.getAnnotation(proceedingJoinPoint, DeleteRequest.class), AspectUtils.getResultType(proceedingJoinPoint));
	}
}
