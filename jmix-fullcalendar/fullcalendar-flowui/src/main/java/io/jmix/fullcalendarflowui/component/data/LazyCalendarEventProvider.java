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

package io.jmix.fullcalendarflowui.component.data;

import io.jmix.fullcalendarflowui.component.FullCalendar;

import java.time.LocalDate;
import java.util.List;
import java.util.TimeZone;

/**
 * Interface to be implemented by event providers that should load items by request.
 * <p>
 * The {@link #onItemsFetch(ItemsFetchContext)} is called in the following cases:
 * <ul>
 *     <li>
 *         When the user navigates to the calendar view that has wider date range than previous view.
 *     </li>
 *     <li>
 *         When {@link FullCalendar}'s navigation methods are invoked, e.g. {@link FullCalendar#navigateToNext()}.
 *     </li>
 *     <li>
 *          When time zone of component is changed.
 *     </li>
 * </ul>
 * By default {@link FullCalendar} calls {@link #onItemsFetch(ItemsFetchContext)} immediately after adding
 * the provider. If calendar is not attached to the UI, loading will be performed after attaching component
 * to the UI.
 *
 * @see LazyEntityCalendarEventRetriever
 * @see CalendarEventRetriever
 */
public interface LazyCalendarEventProvider extends BaseCalendarEventProvider {

    /**
     * A callback method that is invoked by {@link FullCalendar}, for instance, when the user navigates to
     * next/previous dates.
     *
     * @param context context that contains information about date range
     * @return a list of fetched calendar events
     */
    List<CalendarEvent> onItemsFetch(ItemsFetchContext context);

    /**
     * A fetch context that is used for loading events.
     */
    class ItemsFetchContext {
        protected LazyCalendarEventProvider eventProvider;

        protected LocalDate startDate;

        protected LocalDate endDate;

        protected TimeZone componentTimeZone;

        public ItemsFetchContext(LazyCalendarEventProvider eventProvider,
                                 LocalDate startDate,
                                 LocalDate endDate,
                                 TimeZone componentTimeZone) {
            this.eventProvider = eventProvider;
            this.startDate = startDate;
            this.endDate = endDate;
            this.componentTimeZone = componentTimeZone;
        }

        public LazyCalendarEventProvider getEventProvider() {
            return eventProvider;
        }

        /**
         * The return date is the left border of the visible range in the component. This date corresponds to the
         * component's time zone {@link FullCalendar#getTimeZone()}, as if it were a date-time object with zero time.
         *
         * @return left border of visible range in component
         */
        public LocalDate getStartDate() {
            return startDate;
        }

        /**
         * The return date is the right border of the visible range in the component. This date corresponds to the
         * component's time zone {@link FullCalendar#getTimeZone()}, as if it were a date-time object with zero time.
         *
         * @return right border of visible range in calendar
         */
        public LocalDate getEndDate() {
            return endDate;
        }

        /**
         * @return component's time zone
         */
        public TimeZone getComponentTimeZone() {
            return componentTimeZone;
        }
    }
}
