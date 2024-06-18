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

package io.jmix.flowui.data.binding;

import com.vaadin.flow.component.HtmlContainer;
import io.jmix.flowui.data.ValueSource;
import io.jmix.flowui.kit.component.formatter.Formatter;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.InstanceContainer;

public interface HtmlContainerReadonlyDataBinding {

    void bind(HtmlContainer htmlComponent, ValueSource<?> valueSource);

    void bind(HtmlContainer htmlComponent, ValueSource<?> valueSource, Formatter<Object> formatter);

    void bind(HtmlContainer htmlComponent, InstanceContainer<?> dataContainer, String property);

    void bind(HtmlContainer htmlComponent, InstanceContainer<?> dataContainer, String property, Formatter<Object> format);

    void bind(HtmlContainer htmlComponent, CollectionContainer<?> dataContainer);

    void bind(HtmlContainer htmlComponent, CollectionContainer<?> dataContainer, Formatter<Object> format);

    void unbind(HtmlContainer htmlContainer);
}