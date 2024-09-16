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

package io.jmix.fullcalendarflowui.kit.meta;

import io.jmix.flowui.kit.meta.StudioElementsGroup;
import io.jmix.flowui.kit.meta.StudioUiKit;

@StudioUiKit(studioClassloaderDependencies = "io.jmix.fullcalendar:jmix-fullcalendar-flowui-kit")
public interface StudioFullCalendarElementsGroups {

    @StudioElementsGroup(
            name = "Data Providers",
            xmlElement = "dataProviders",
            xmlnsAlias = "calendar",
            xmlns = "http://jmix.io/schema/fullcalendar/ui",
            elementClassFqn = "io.jmix.fullcalendarflowui.component.data.CalendarDataProvider",
            target = "io.jmix.fullcalendarflowui.component.FullCalendar",
            icon = "io/jmix/fullcalendarflowui/kit/meta/icon/unknownComponent.svg"
    )
    void dataProviders();

    @StudioElementsGroup(
            name = "Custom Display Modes",
            xmlElement = "customDisplayModes",
            xmlnsAlias = "calendar",
            xmlns = "http://jmix.io/schema/fullcalendar/ui",
            elementClassFqn = "io.jmix.fullcalendarflowui.kit.component.model.CustomCalendarDisplayMode",
            target = "io.jmix.fullcalendarflowui.component.FullCalendar",
            icon = "io/jmix/fullcalendarflowui/kit/meta/icon/unknownComponent.svg"
    )
    void customDisplayModes();

    @StudioElementsGroup(
            name = "Properties",
            xmlElement = "properties",
            xmlnsAlias = "calendar",
            xmlns = "http://jmix.io/schema/fullcalendar/ui",
            elementClassFqn = "io.jmix.fullcalendarflowui.kit.meta.group.StudioFullCalendarProperties",
            target = {
                    "io.jmix.fullcalendarflowui.kit.component.model.CustomCalendarDisplayMode",
                    "io.jmix.fullcalendarflowui.kit.component.model.DayGridDayProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.DayGridWeekProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.DayGridMonthProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.DayGridYearProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.ListDayProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.ListWeekProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.ListMonthProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.ListYearProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.TimeGridDayProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.TimeGridWeekProperties",
                    "io.jmix.fullcalendarflowui.kit.component.model.MultiMonthYearProperties",
            },
            icon = "io/jmix/mapsflowui/kit/meta/icon/unknownComponent.svg"
    )
    void properties();

    @StudioElementsGroup(
            name = "Business Hours",
            xmlElement = "businessHours",
            xmlnsAlias = "calendar",
            xmlns = "http://jmix.io/schema/fullcalendar/ui",
            elementClassFqn = "io.jmix.fullcalendarflowui.component.model.BusinessHours",
            target = "io.jmix.fullcalendarflowui.component.FullCalendar",
            icon = "io/jmix/fullcalendarflowui/kit/meta/icon/unknownComponent.svg"
    )
    void businessHours();

    @StudioElementsGroup(
            name = "Hidden Days",
            xmlElement = "hiddenDays",
            xmlnsAlias = "calendar",
            xmlns = "http://jmix.io/schema/fullcalendar/ui",
            elementClassFqn = "io.jmix.fullcalendarflowui.kit.meta.group.StudioFullCalendarHiddenDays",
            target = "io.jmix.fullcalendarflowui.component.FullCalendar",
            icon = "io/jmix/fullcalendarflowui/kit/meta/icon/unknownComponent.svg"
    )
    void hiddenDays();
}
