package ru.asgubin.rsr.report.chapter8;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Event;
import ru.asgubin.rsr.clients.rest.rsrdb.model.Param;
import ru.asgubin.rsr.report.factory.TableRow;

import java.util.List;

@XmlRootElement(name = "tableRow_8_1_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableRow_8_1_1 extends TableRow {

    protected TableRow_8_1_1() {
    }

    public TableRow_8_1_1(Event event, List<Param> paramList) {
        super(event, paramList);
    }

    public TableRow_8_1_1(String id, String text, String mean, String distPar1) {
        super(id, text, mean, distPar1);
    }
}
