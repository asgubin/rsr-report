package ru.asgubin.rsr.report.chapter6;

import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Param;
import ru.asgubin.rsr.report.factory.BasicEvent;
import ru.asgubin.rsr.report.types.EventModelType;
import ru.asgubin.rsr.report.types.ParamType;

import java.util.List;

public class BasicEvent_6_1_1 extends BasicEvent {

    private int eqGroupId;
    private String eqKKS;
    private String eventModel;
    private String missionTime;
    private String probability;
    private String failureRate;
    private String testInterval;

    private String failureType;

    protected BasicEvent_6_1_1() {
    }

    public BasicEvent_6_1_1(Event event, List<Param> paramList,
                            int eqGroupId, String eqKKS, String failureType) {
        super(event.getId(), event.getText());

        this.eqGroupId = eqGroupId;
        this.eqKKS = eqKKS;

        if (event.getModel() == EventModelType.REPAIRABLE.getValue()) {
            this.eventModel = "REPAIRABLE";
        }
        else if (event.getModel() == EventModelType.TESTED.getValue()) {
            this.eventModel = "Периодически контролируемый";
        }
        else if (event.getModel() == EventModelType.PROBABILITY.getValue()) {
            this.eventModel = "Вероятность";
        }
        else if (event.getModel() == EventModelType.MISSION_TIME.getValue()) {
            this.eventModel = "Время выполнения";
        }
        else if (event.getModel() == EventModelType.FREQUENCY.getValue()) {
            this.eventModel = "FREQUENCY";
        }
        else if (event.getModel() == EventModelType.NON_REPAIRABLE.getValue()) {
            this.eventModel = "NON_REPAIRABLE";
        }
        else {
            this.eventModel = "-";
        }

        this.missionTime = "-";
        this.probability = "-";
        this.failureRate = "-";
        this.testInterval = "-";

        for (Param param : paramList) {

            if (param.getType() == ParamType.MISSION_TIME.getValue()) {
                this.missionTime = param.getId();
            }
            else if (param.getType() == ParamType.PROBABILITY.getValue()) {
                this.probability = param.getId();
            }
            else if (param.getType() == ParamType.FAILURE_RATE.getValue()) {
                this.failureRate = param.getId();
            }
            else if (param.getType() == ParamType.TEST_INTERVAL.getValue()) {
                this.testInterval = param.getId();
            }
        }

        this.failureType = failureType;
    }

    public int getEqGroupId() {
        return eqGroupId;
    }

    public void setEqGroupId(int eqGroupId) {
        this.eqGroupId = eqGroupId;
    }

    public String getEqKKS() {
        return eqKKS;
    }

    public void setEqKKS(String eqKKS) {
        this.eqKKS = eqKKS;
    }

    public String getEventModel() {
        return eventModel;
    }

    public void setEventModel(String eventModel) {
        this.eventModel = eventModel;
    }

    public String getMissionTime() {
        return missionTime;
    }

    public void setMissionTime(String missionTime) {
        this.missionTime = missionTime;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(String failureRate) {
        this.failureRate = failureRate;
    }

    public String getTestInterval() {
        return testInterval;
    }

    public void setTestInterval(String testInterval) {
        this.testInterval = testInterval;
    }

    public String getFailureType() {
        return failureType;
    }

    public void setFailureType(String failureType) {
        this.failureType = failureType;
    }
}
