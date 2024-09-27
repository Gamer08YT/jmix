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

package io.jmix.search.index.impl;

import io.jmix.core.common.util.Preconditions;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Class encapsulates logic of comparing the mapping's fields that are "leaf" field. That means that the field doen't
 * contain any inner objects and is just a field of a primitive type.
 */
@Component("search_MappingFieldComparator")
public class MappingFieldComparator {

    public static final String TYPE_KEY = "type";

    public boolean isLeafField(@NotNull Map<String, Object> mapping) {
        return mapping.get(TYPE_KEY) != null && mapping.get(TYPE_KEY) instanceof String;
    }

    public MappingComparingResult compareLeafFields(
            @NotNull Map<String, Object> searchIndexMapping,
            @NotNull Map<String, Object> applicationMapping) {
        Preconditions.checkNotNullArgument(
                searchIndexMapping,
                "'searchIndexMapping' parameter value can't be null.");
        Preconditions.checkNotNullArgument(
                applicationMapping,
                "'applicationMapping' parameter value can't be null.");
        return searchIndexMapping.equals(applicationMapping)
                ? MappingComparingResult.EQUAL
                : MappingComparingResult.NOT_COMPATIBLE;
    }
}
