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

package io.jmix.fullcalendar.datatype;

import io.jmix.core.annotation.Internal;
import io.jmix.core.common.util.Preconditions;
import io.jmix.fullcalendar.DayOfWeek;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Internal
public final class DaysOfWeekDatatypeUtils {
    private DaysOfWeekDatatypeUtils() {
    }

    public static List<DayOfWeek> getOrderedByFirstDay(DayOfWeek firstDay) {
        Preconditions.checkNotNullArgument(firstDay);

        List<DayOfWeek> moveToEnd = new ArrayList<>();

        List<DayOfWeek> result = new ArrayList<>(List.of(DayOfWeek.values()));
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek != firstDay) {
                moveToEnd.add(dayOfWeek);
            }
        }

        result.removeAll(moveToEnd);
        result.addAll(moveToEnd);

        return result;
    }

    public static List<DayOfWeek> sortByFirstDay(Collection<DayOfWeek> daysOfWeek, DayOfWeek firstDay) {
        Preconditions.checkNotNullArgument(daysOfWeek);
        Preconditions.checkNotNullArgument(firstDay);

        List<DayOfWeek> orderedDays = getOrderedByFirstDay(firstDay);

        List<DayOfWeek> sorted = new ArrayList<>(daysOfWeek.size());
        for (DayOfWeek dayOfWeek : orderedDays) {
            if (daysOfWeek.contains(dayOfWeek)) {
                sorted.add(dayOfWeek);
            }
        }
        return sorted;
    }
}