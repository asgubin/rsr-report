package ru.asgubin.rsr.report.chapter10;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Param;
import ru.asgubin.rsr.report.types.ParamType;

@XmlRootElement(name = "tableRow_10_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableRow_10_1 {

    private String type;
    private String id;
    private String text;
    private String mean;
    private String distPar1;

    protected TableRow_10_1() {
    }

    public TableRow_10_1(Param param) {

        if (param.getType() == ParamType.BETA_FACTOR.getValue()) {
            this.type = "Бета-фактор";
        }
        else if (param.getType() == ParamType.GAMMA_FACTOR.getValue()) {
            this.type = "Гамма-фактор";
        }
        else if (param.getType() == ParamType.DELTA_FACTOR.getValue()) {
            this.type = "Дельта-фактор";
        }
        else if (param.getType() == ParamType.ALPHA_2.getValue()) {
            this.type = "Альфа-фактор 2";
        }
        else if (param.getType() == ParamType.ALPHA_3.getValue()) {
            this.type = "Альфа-фактор 3";
        }
        else if (param.getType() == ParamType.ALPHA_4.getValue()) {
            this.type = "Альфа-фактор 4";
        }
        else if (param.getType() == ParamType.ALPHA_5.getValue()) {
            this.type = "Альфа-фактор 5";
        }
        else if (param.getType() == ParamType.ALPHA_6.getValue()) {
            this.type = "Альфа-фактор 6";
        }
        else if (param.getType() == ParamType.ALPHA_7.getValue()) {
            this.type = "Альфа-фактор 7";
        }
        else if (param.getType() == ParamType.ALPHA_8.getValue()) {
            this.type = "Альфа-фактор 8";
        }
        else if (param.getType() == ParamType.PROBABILITY.getValue()) {
            this.type = "Вероятность отказов, 1/треб";
        }
        else if (param.getType() == ParamType.FAILURE_RATE.getValue()) {
            this.type = "Интенсивность отказов, 1/час";
        }
        else {
            this.type = "-";
        }

        this.id = param.getId();
        if (param.getText() != null) {
            this.text = param.getText().isBlank() ? "-" : param.getText();
        }
        else {
            this.text = "-";
        }
        this.mean = String.format("%.2E", param.getMean());
        this.distPar1 = String.format("%.2f", param.getDistPar1());
    }

    public TableRow_10_1(String type, String id, String text,
                         String mean, String distPar1) {
        this.type = type;
        this.id = id;
        this.text = text;
        this.mean = mean;
        this.distPar1 = distPar1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getDistPar1() {
        return distPar1;
    }

    public void setDistPar1(String distPar1) {
        this.distPar1 = distPar1;
    }
}
