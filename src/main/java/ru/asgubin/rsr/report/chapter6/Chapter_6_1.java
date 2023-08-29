package ru.asgubin.rsr.report.chapter6;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_6_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_6_1 {

    @XmlElement(name = "table_6_1_1")
    private List<TableRow_6_1_1> table_6_1_1;

    protected Chapter_6_1() {
    }

    public Chapter_6_1(List<TableRow_6_1_1> table_6_1_1) {
        this.table_6_1_1 = table_6_1_1;
    }

    public List<TableRow_6_1_1> getTable_6_1_1() {
        return table_6_1_1;
    }

    public void setTable_6_1_1(List<TableRow_6_1_1> table_6_1_1) {
        this.table_6_1_1 = table_6_1_1;
    }
}
