package ru.asgubin.rsr.report.factory;

public class BasicEvent {
    private String id;
    private String text;

    protected BasicEvent(){
    }

    public BasicEvent(String id, String text) {
        this.id = id;
        this.text = text == null || text.isBlank() ? "-" : text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
