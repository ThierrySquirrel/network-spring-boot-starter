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

package com.github.thierrysquirrel.core.utils;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * ClassName: ObjectUtils 
 * Description: 
 * date: 2019/6/8 21:20
 * @author ThierrySquirrel
 * @version
 * @since JDK 1.8
 */
public class ObjectUtils {

	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return Boolean.TRUE;
		}

		if (obj instanceof Optional) {
			return !((Optional) obj).isPresent();
		}
		if (obj instanceof CharSequence) {
			return ((CharSequence) obj).length() == 0;
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		if (obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		}
		if (obj instanceof Map) {
			return ((Map) obj).isEmpty();
		}

		return Boolean.FALSE;
	}
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

}
