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
public class DomViewInfo implements Serializable {

    protected String activeEnd;

    protected String activeStart;

    protected String currentEnd;

    protected String currentStart;

    protected String type;

    public String getActiveEnd() {
        return activeEnd;
    }

    public void setActiveEnd(String activeEnd) {
        this.activeEnd = activeEnd;
    }

    public String getActiveStart() {
        return activeStart;
    }

    public void setActiveStart(String activeStart) {
        this.activeStart = activeStart;
    }

    public String getCurrentEnd() {
        return currentEnd;
    }

    public void setCurrentEnd(String currentEnd) {
        this.currentEnd = currentEnd;
    }

    public String getCurrentStart() {
        return currentStart;
    }

    public void setCurrentStart(String currentStart) {
        this.currentStart = currentStart;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
