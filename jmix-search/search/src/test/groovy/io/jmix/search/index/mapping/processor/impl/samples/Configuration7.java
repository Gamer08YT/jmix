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

package io.jmix.search.index.mapping.processor.impl.samples;

import io.jmix.search.index.annotation.DynamicAttributes;
import io.jmix.search.index.annotation.JmixEntitySearchIndex;

@JmixEntitySearchIndex(entity = TestEntity.class)
@DynamicAttributes(
        includeCategories = {"c1", "c2"},
        excludeCategories = {"c2", "c3"},
        includeFields = {"f1", "f2"},
        excludeFields = {"f1", "f2"})
public interface Configuration7 {
}
