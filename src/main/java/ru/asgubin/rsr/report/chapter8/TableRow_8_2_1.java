package ru.asgubin.rsr.report.chapter8;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Param;

import java.util.List;

@XmlRootElement(name = "tableRow_8_2_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableRow_8_2_1 {

    private String id;

    @XmlElement(name = "events")
    private List<Event> events;

    private String text;

    private String ccfModel;

    @XmlElement(name = "params")
    private List<Param> params;

    public TableRow_8_2_1() {
    }

    public TableRow_8_2_1(String id, List<Event> events,
                          String text, String ccfModel,
                          List<Param> params) {
        this.id = id;
        this.events = events;
        this.text = text;
        this.ccfModel = ccfModel;
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCcfModel() {
        return ccfModel;
    }

    public void setCcfModel(String ccfModel) {
        this.ccfModel = ccfModel;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }
}
