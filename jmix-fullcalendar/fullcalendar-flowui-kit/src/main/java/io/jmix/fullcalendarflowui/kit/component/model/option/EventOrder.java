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

package io.jmix.fullcalendarflowui.kit.component.model.option;

import io.jmix.fullcalendarflowui.kit.component.model.JsFunction;
import jakarta.annotation.Nullable;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static io.jmix.fullcalendarflowui.kit.component.model.option.OptionUtils.EVENT_ORDER;

/**
 * INTERNAL.
 */
public class EventOrder extends CalendarOption implements Serializable {

    protected List<String> DEFAULT_ORDER = List.of("start", "-duration", "allDay", "title");

    protected boolean explicitlySetList = false;

    protected List<String> eventOrder;

    protected JsFunction jsFunction = null;

    public EventOrder() {
        super(EVENT_ORDER);

        eventOrder = DEFAULT_ORDER;
    }

    public List<String> getEventOrder() {
        return explicitlySetList ? eventOrder : Collections.emptyList();
    }

    public List<String> getSerializedEventOrder() {
        return eventOrder;
    }

    public void setEventOrder(@Nullable List<String> eventOrder) {
        this.eventOrder = eventOrder;

        if (eventOrder == null) {
            this.eventOrder = DEFAULT_ORDER;
            explicitlySetList = false;
        } else {
            explicitlySetList = true;
        }

        markAsDirty();
    }

    @Nullable
    public JsFunction getJsFunction() {
        return jsFunction;
    }

    public void setJsFunction(@Nullable JsFunction jsFunction) {
        this.jsFunction = jsFunction;

        markAsDirty();
    }
}
