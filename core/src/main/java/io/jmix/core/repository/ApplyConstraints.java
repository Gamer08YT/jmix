/*
 * Copyright 2021 Haulmont.
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

package io.jmix.core.repository;

import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.constraint.AccessConstraint;
import io.jmix.core.impl.repository.support.method_metadata.MethodMetadataHelper;

import java.lang.annotation.*;

/**
 * Disables CRUD and row level {@link AccessConstraint}s for {@link JmixDataRepository}.
 * <p>
 * {@link UnconstrainedDataManager} will be used instead of DataManager when this annotation present.
 * <p>
 *
 * @see MethodMetadataHelper#determineApplyConstraints
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApplyConstraints {
    boolean value() default true;
}
