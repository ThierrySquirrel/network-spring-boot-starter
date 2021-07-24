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

import com.github.thierrysquirrel.network.constants.RequestBodyConstants;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.Map;

/**
 * ClassName: RequestBodyBuilder
 * Description:
 * date: 2019/12/19 15:26
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class RequestBodyBuilder {
	private RequestBodyBuilder() {
	}

	public static RequestBody builderFileBody(Map<String, File> fileMap) {
		if (ObjectUtils.isEmpty(fileMap)) {
			return null;
		}
		MultipartBody.Builder builder = new MultipartBody.Builder();
		fileMap.forEach((name, file) -> builder.addFormDataPart(name, file.getName(), RequestBody.create(file, MediaType.get(RequestBodyConstants.MEDIA_TYPE_FILE.getValue()))));
		return builder.build();
	}

	public static RequestBody builderBody(String body) {
		if (ObjectUtils.isEmpty(body)) {
			return null;
		}
		return RequestBody.Companion.create(body, MediaType.Companion.get(RequestBodyConstants.MEDIA_TYPE_BODY.getValue()));
	}
}
