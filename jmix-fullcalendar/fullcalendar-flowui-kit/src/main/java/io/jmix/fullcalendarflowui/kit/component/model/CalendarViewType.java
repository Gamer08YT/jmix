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

package io.jmix.fullcalendarflowui.kit.component.model;

/**
 * dayGridPlugin: dayGridYear, dayGridMonth, dayGridWeek, dayGridDay, dayGrid
 * timeGridPlugin: timeGridWeek, timeGridDay, timeGrid
 * listPlugin: listYear, listMonth, listWeek, listDay
 * multiMonthPlugin: multiMonthYear, multiMonth
 */
public enum CalendarViewType implements CalendarView {
    /**
     * A "generic" value, can be used as a type for {@link CustomCalendarView}, or with "visibleRange" option.
     */
    DAY_GRID("dayGrid"),
    DAY_GRID_DAY("dayGridDay"),
    DAY_GRID_WEEK("dayGridWeek"),
    DAY_GRID_MONTH("dayGridMonth"),
    DAY_GRID_YEAR("dayGridYear"),

    /**
     * A "generic" value, can be used as a type for {@link CustomCalendarView}, or with "visibleRange" option.
     */
    TIME_GRID("timeGrid"),
    TIME_GRID_DAY("timeGridDay"),
    TIME_GRID_WEEK("timeGridWeek"),

    /**
     * A "generic" value, can be used as a type for {@link CustomCalendarView}, or with "visibleRange" option.
     */
    LIST("list"),
    LIST_DAY("listDay"),
    LIST_WEEK("listWeek"),
    LIST_MONTH("listMonth"),
    LIST_YEAR("listYear"),

    /**
     * A "generic" value, can be used as a type for {@link CustomCalendarView}, or with "visibleRange" option.
     */
    MULTI_MONTH("multiMonth"),
    MULTI_MONTH_YEAR("multiMonthYear");

    private final String id;

    CalendarViewType(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    public static CalendarViewType fromId(String id) {
        for (CalendarViewType calendarView : CalendarViewType.values()) {
            if (calendarView.getId().equals(id)) {
                return calendarView;
            }
        }
        return null;
    }
}