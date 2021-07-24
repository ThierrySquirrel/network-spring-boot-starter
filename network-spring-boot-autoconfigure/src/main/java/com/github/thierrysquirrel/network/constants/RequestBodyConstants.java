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

package com.github.thierrysquirrel.network.constants;

/**
 * ClassName: RequestBodyConstants
 * Description:
 * date: 2019/12/19 15:28
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public enum RequestBodyConstants {
	/**
	 * application/octet-stream
	 */
	MEDIA_TYPE_FILE("application/octet-stream;charset=utf-8"),
	/**
	 * application/json
	 */
	MEDIA_TYPE_BODY("application/json;charset=utf-8");
	private String value;

	RequestBodyConstants(String value) {

		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
