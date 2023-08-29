package ru.asgubin.rsr.report.chapter10;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_10")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_10 {

    @XmlElement(name = "table_10_1")
    private List<TableRow_10_1> table_10_1;

    protected Chapter_10() {
    }

    public Chapter_10(List<TableRow_10_1> table_10_1) {
        this.table_10_1 = table_10_1;
    }

    public List<TableRow_10_1> getTable_10_1() {
        return table_10_1;
    }

    public void setTable_10_1(List<TableRow_10_1> table_10_1) {
        this.table_10_1 = table_10_1;
    }
}
