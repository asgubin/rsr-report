package ru.asgubin.rsr.report.chapter6;

import jakarta.xml.bind.annotation.*;
import ru.asgubin.rsr.report.chapter6.pojo.*;

import java.util.List;

@XmlRootElement(name = "tableRow_6_1_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableRow_6_1_1 {

    private String number;

    @XmlTransient
    private int eqGroupId;

    private String eqGroupText;

    @XmlElement(name = "eqKKSList")
    private List<EqKks> eqKKSList;

    @XmlElement(name = "eventTextList")
    private List<EventText> eventTextList;

    @XmlElement(name = "eventIdList")
    private List<EventId> eventIdList;

    @XmlElement(name = "eventModelList")
    private List<EventModel> eventModelList;

    @XmlElement(name = "missionTimeList")
    private List<MissionTime> missionTimeList;

    @XmlElement(name = "probabilityList")
    private List<Probability> probabilityList;

    @XmlElement(name = "failureRateList")
    private List<FailureRate> failureRateList;

    @XmlElement(name = "testIntervalList")
    private List<TestInterval> testIntervalList;

    protected TableRow_6_1_1() {
    }

    public TableRow_6_1_1(String number, int eqGroupId, String eqGroupText,
                          List<EqKks> eqKKSList, List<EventText> eventTextList,
                          List<EventId> eventIdList, List<EventModel> eventModelList,
                          List<MissionTime> missionTimeList, List<Probability> probabilityList,
                          List<FailureRate> failureRateList, List<TestInterval> testIntervalList) {
        this.number = number;
        this.eqGroupId = eqGroupId;
        this.eqGroupText = eqGroupText;
        this.eqKKSList = eqKKSList;
        this.eventTextList = eventTextList;
        this.eventIdList = eventIdList;
        this.eventModelList = eventModelList;
        this.missionTimeList = missionTimeList;
        this.probabilityList = probabilityList;
        this.failureRateList = failureRateList;
        this.testIntervalList = testIntervalList;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getEqGroupId() {
        return eqGroupId;
    }

    public void setEqGroupId(int eqGroupId) {
        this.eqGroupId = eqGroupId;
    }

    public String getEqGroupText() {
        return eqGroupText;
    }

    public void setEqGroupText(String eqGroupText) {
        this.eqGroupText = eqGroupText;
    }

    public List<EqKks> getEqKKSList() {
        return eqKKSList;
    }

    public void setEqKKSList(List<EqKks> eqKKSList) {
        this.eqKKSList = eqKKSList;
    }

    public List<EventText> getEventTextList() {
        return eventTextList;
    }

    public void setEventTextList(List<EventText> eventTextList) {
        this.eventTextList = eventTextList;
    }

    public List<EventId> getEventIdList() {
        return eventIdList;
    }

    public void setEventIdList(List<EventId> eventIdList) {
        this.eventIdList = eventIdList;
    }

    public List<EventModel> getEventModelList() {
        return eventModelList;
    }

    public void setEventModelList(List<EventModel> eventModelList) {
        this.eventModelList = eventModelList;
    }

    public List<MissionTime> getMissionTimeList() {
        return missionTimeList;
    }

    public void setMissionTimeList(List<MissionTime> missionTimeList) {
        this.missionTimeList = missionTimeList;
    }

    public List<Probability> getProbabilityList() {
        return probabilityList;
    }

    public void setProbabilityList(List<Probability> probabilityList) {
        this.probabilityList = probabilityList;
    }

    public List<FailureRate> getFailureRateList() {
        return failureRateList;
    }

    public void setFailureRateList(List<FailureRate> failureRateList) {
        this.failureRateList = failureRateList;
    }

    public List<TestInterval> getTestIntervalList() {
        return testIntervalList;
    }

    public void setTestIntervalList(List<TestInterval> testIntervalList) {
        this.testIntervalList = testIntervalList;
    }
}
