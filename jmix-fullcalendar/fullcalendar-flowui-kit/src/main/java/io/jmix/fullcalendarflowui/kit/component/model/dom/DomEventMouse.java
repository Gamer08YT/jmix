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

package io.jmix.fullcalendarflowui.kit.component.model.dom;

import java.io.Serializable;

/**
 * INTERNAL.
 */
public class DomEventMouse implements Serializable {

    protected DomCalendarEvent event;

    protected DomMouseEventDetails mouseDetails;

    protected DomViewInfo view;

    public DomCalendarEvent getEvent() {
        return event;
    }

    public void setEvent(DomCalendarEvent event) {
        this.event = event;
    }

    public DomMouseEventDetails getMouseDetails() {
        return mouseDetails;
    }

    public void setMouseDetails(DomMouseEventDetails mouseDetails) {
        this.mouseDetails = mouseDetails;
    }

    public DomViewInfo getView() {
        return view;
    }

    public void setView(DomViewInfo view) {
        this.view = view;
    }
}
