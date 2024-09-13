/*
 * Copyright 2024 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.search.exception;

import java.util.List;

/**
 * An exception that is thrown when the problem with parser resolving is occurred. The parser is need for
 * the fields of the "File" type indexing.
 */
public abstract class ParserResolvingException extends Exception {

    protected static String getSupportedExtensionsString(List<String> supportedExtensions){
        return String.join(", ", supportedExtensions);

    }

    public ParserResolvingException(String message) {
        super(message);
    }
}