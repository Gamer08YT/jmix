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

package io.jmix.fullcalendarflowui.component.event;

import io.jmix.fullcalendarflowui.component.FullCalendar;
import io.jmix.fullcalendarflowui.kit.component.model.CalendarDisplayModes;

import java.time.LocalDateTime;

/**
 * The context for generating class names for "now" indicator in timed display modes:
 * {@link CalendarDisplayModes#TIME_GRID_DAY} and {@link CalendarDisplayModes#TIME_GRID_WEEK}.
 */
public class NowIndicatorClassNamesContext extends AbstractFullCalendarContext {

    protected final boolean isAxis;

    protected final LocalDateTime dateTime;

    protected final DisplayModeInfo displayModeInfo;

    public NowIndicatorClassNamesContext(FullCalendar fullCalendar,
                                         boolean isAxis,
                                         LocalDateTime dateTime,
                                         DisplayModeInfo displayModeInfo) {
        super(fullCalendar);
        this.isAxis = isAxis;
        this.dateTime = dateTime;
        this.displayModeInfo = displayModeInfo;
    }

    /**
     * @return {@code true} if class names will be applied for now-indicator's arrow, otherwise class names will be
     * applied for now-indicator's line
     */
    public boolean isAxis() {
        return isAxis;
    }

    /**
     * Returns date-time as is from component without transformation. It means that value corresponds component's
     * TimeZone.
     * <p>
     * For now-indicator's line the time part will be {@code 00:00:00}.
     *
     * @return indicator's date-time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * @return information about current calendar's display mode
     */
    public DisplayModeInfo getDisplayModeInfo() {
        return displayModeInfo;
    }
}
