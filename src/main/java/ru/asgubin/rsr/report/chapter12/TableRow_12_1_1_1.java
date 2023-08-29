package ru.asgubin.rsr.report.chapter12;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tableRow_12_1_1_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableRow_12_1_1_1 {

    private String num;
    private String probability;
    private String contribution;
    private String eventId;
    private String eventText;

//    private Mcs mcs;
//
//    @XmlElement(name = "eventMcsList")
//    private List<EventMcsResultDb> eventMcs;

    public TableRow_12_1_1_1() {
    }

    public TableRow_12_1_1_1(String num, String probability, String contribution, String eventId, String eventText) {
        this.num = num;
        this.probability = probability;
        this.contribution = contribution;
        this.eventId = eventId;
        this.eventText = eventText;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }
}
