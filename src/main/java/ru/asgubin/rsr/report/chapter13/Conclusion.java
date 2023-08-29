package ru.asgubin.rsr.report.chapter13;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import ru.asgubin.rsr.rsrresultdb.BeImp;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Acase;

@XmlRootElement(name = "conclusion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Conclusion {

    @XmlTransient
    private static final double BOUND = 3.0;

    private String funcId;
    private String funcText;
    private String mean;
    private String highBound;
    private String lowBound;
    private String resultBound;
    private BeImp beImp;

    protected Conclusion() {
    }

    public Conclusion(Acase acase, BeImp beImp) {
        this.funcId = acase.getId();
        this.funcText = acase.getText();
        this.mean = String.format("%.2E", acase.getMean());
        this.highBound = acase.getP95()/acase.getMean() < BOUND ? "менее" : "более";
        this.lowBound = acase.getMean()/acase.getP05() < BOUND ? "менее" : "более";

        if (acase.getP95()/acase.getMean() < BOUND
                && acase.getMean()/acase.getP05() < BOUND) {
            resultBound = "низком";
        }
        else {
            resultBound = "высоком";
        }

        this.beImp = beImp;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncText() {
        return funcText;
    }

    public void setFuncText(String funcText) {
        this.funcText = funcText;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getHighBound() {
        return highBound;
    }

    public void setHighBound(String highBound) {
        this.highBound = highBound;
    }

    public String getLowBound() {
        return lowBound;
    }

    public void setLowBound(String lowBound) {
        this.lowBound = lowBound;
    }

    public String getResultBound() {
        return resultBound;
    }

    public void setResultBound(String resultBound) {
        this.resultBound = resultBound;
    }

    public BeImp getBeImp() {
        return beImp;
    }

    public void setBeImp(BeImp beImp) {
        this.beImp = beImp;
    }
}
