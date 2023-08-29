package ru.asgubin.rsr.report.chapter12.pojo;

public class EventMcsResultDb {
    private String eventName;
    private String eventText;

    public EventMcsResultDb() {
    }

    public EventMcsResultDb(String eventName, String eventText) {
        this.eventName = eventName;
        this.eventText = eventText;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }
}
