package ru.asgubin.rsr.report.factory;

import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Param;
import ru.asgubin.rsr.report.types.ParamType;

import java.util.List;

public class TableRow extends BasicEvent {

    private String mean;
    private String distPar1;

    protected TableRow() {
    }

    public TableRow(Event event, List<Param> paramList) {
        super(event.getId(), event.getText());

        for (Param param : paramList) {

            if (param.getType() == ParamType.PROBABILITY.getValue() ||
                    param.getType() == ParamType.FAILURE_RATE.getValue()) {

                this.mean = String.format("%.2E", param.getMean()).isBlank() ? "-" : String.format("%.2E", param.getMean());
                this.distPar1 = String.format("%.2f", param.getDistPar1()).isBlank() ? "-" : String.format("%.2f", param.getDistPar1());

                break;
            }
        }
    }

    public TableRow(String id, String text,
                    String mean, String distPar1) {

        super(id, text);

        this.mean = mean;
        this.distPar1 = distPar1;
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
