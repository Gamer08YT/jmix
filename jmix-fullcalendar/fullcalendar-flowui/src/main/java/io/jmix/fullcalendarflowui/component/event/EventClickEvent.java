package io.jmix.fullcalendarflowui.component.event;

import io.jmix.fullcalendarflowui.component.FullCalendar;
import io.jmix.fullcalendarflowui.component.data.CalendarEvent;
import io.jmix.fullcalendarflowui.component.data.BaseCalendarEventProvider;
import io.jmix.fullcalendarflowui.kit.component.event.MouseEventDetails;

public class EventClickEvent extends AbstractClickEvent {

    protected final CalendarEvent calendarEvent;
    protected final BaseCalendarEventProvider eventProvider;
    protected final ViewInfo viewInfo;

    public EventClickEvent(FullCalendar source,
                           boolean fromClient,
                           MouseEventDetails mouseEventDetails,
                           CalendarEvent calendarEvent,
                           BaseCalendarEventProvider eventProvider,
                           ViewInfo viewInfo) {
        super(source, fromClient, mouseEventDetails);

        this.calendarEvent = calendarEvent;
        this.eventProvider = eventProvider;
        this.viewInfo = viewInfo;
    }

    public CalendarEvent getCalendarEvent() {
        return calendarEvent;
    }

    public BaseCalendarEventProvider getEventProvider() {
        return eventProvider;
    }

    public ViewInfo getViewInfo() {
        return viewInfo;
    }
}