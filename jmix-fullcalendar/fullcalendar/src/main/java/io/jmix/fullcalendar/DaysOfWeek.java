package io.jmix.fullcalendar;

import io.jmix.core.common.util.Preconditions;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.*;

public class DaysOfWeek implements Serializable {

    public final Set<DayOfWeek> daysOfWeek;

    public DaysOfWeek(Set<DayOfWeek> daysOfWeek) {
        Preconditions.checkNotNullArgument(daysOfWeek);
        this.daysOfWeek = daysOfWeek;
    }

    public Set<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DaysOfWeek dObj) {
            return CollectionUtils.isEqualCollection(dObj.daysOfWeek, daysOfWeek);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash((daysOfWeek.toArray()));
    }
}
