package ru.asgubin.rsr.report.chapter6.pojo;

public class EventId {
    private String eventId;

    public EventId() {
    }

    public EventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        return this.eventId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EventId)) {
            return false;
        }
        EventId other = (EventId) o;
        return (this.eventId == null && other.eventId == null)
                || (this.eventId != null && this.eventId.equals(other.eventId));
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
