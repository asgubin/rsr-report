package ru.asgubin.rsr.report.chapter6.pojo;

public class EventModel {
    private String eventModel;

    public EventModel() {
    }

    public EventModel(String eventModel) {
        this.eventModel = eventModel;
    }

    @Override
    public int hashCode() {
        return this.eventModel.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EventModel)) {
            return false;
        }
        EventModel other = (EventModel) o;
        return (this.eventModel == null && other.eventModel == null)
                || (this.eventModel != null && this.eventModel.equals(other.eventModel));
    }

    public String getEventModel() {
        return eventModel;
    }

    public void setEventModel(String eventModel) {
        this.eventModel = eventModel;
    }
}
