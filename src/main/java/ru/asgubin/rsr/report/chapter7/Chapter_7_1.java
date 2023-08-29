package ru.asgubin.rsr.report.chapter7;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_7_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_7_1 {

    @XmlElement(name = "table_7_1_1")
    private List<TableRow_7_1_1> table_7_1_1;

    protected Chapter_7_1() {
    }

    public Chapter_7_1(List<TableRow_7_1_1> table_7_1_1) {
        this.table_7_1_1 = table_7_1_1;
    }

    public List<TableRow_7_1_1> getTable_7_1_1() {
        return table_7_1_1;
    }

    public void setTable_7_1_1(List<TableRow_7_1_1> table_7_1_1) {
        this.table_7_1_1 = table_7_1_1;
    }
}
