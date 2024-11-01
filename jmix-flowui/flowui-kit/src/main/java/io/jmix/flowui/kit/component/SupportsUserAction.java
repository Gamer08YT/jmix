/*
 * Copyright 2022 Haulmont.
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

package io.jmix.flowui.kit.component;

import com.vaadin.flow.component.HasValue;

import jakarta.annotation.Nullable;

/**
 * Interface to be implemented by UI components, which provide an API that pretends
 * that the action was invoked by the user on the client side.
 *
 * @param <V> the component value type
 */
public interface SupportsUserAction<V> {

    /**
     * Sets the value of this component as if the user had set it,
     * i.e. {@link HasValue.ValueChangeEvent#isFromClient()} returns {@code true}.
     *
     * @param value the new value
     */
    void setValueFromClient(@Nullable V value);
}
