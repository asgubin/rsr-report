package ru.asgubin.rsr.report.chapter6.pojo;

public class EventText {
    private String eventText;

    public EventText() {
    }

    public EventText(String eventText) {
        this.eventText = eventText;
    }

    @Override
    public int hashCode() {
        return this.eventText.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EventText)) {
            return false;
        }
        EventText other = (EventText) o;
        return (this.eventText == null && other.eventText == null)
                || (this.eventText != null && this.eventText.equals(other.eventText));
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }
}
