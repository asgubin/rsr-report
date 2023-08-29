package ru.asgubin.rsr.report.chapter6;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement(name = "chapter_6_2")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_6_2 {

    @XmlElement(name = "table_6_2_1")
    private List<TableRow_6_2_1> table_6_2_1;

    protected Chapter_6_2() {
    }

    public Chapter_6_2(List<TableRow_6_2_1> table_6_2_1) {
        this.table_6_2_1 = table_6_2_1;
    }

    public List<TableRow_6_2_1> getTable_6_2_1() {
        return table_6_2_1;
    }

    public void setTable_6_2_1(List<TableRow_6_2_1> table_6_2_1) {
        this.table_6_2_1 = table_6_2_1;
    }
}
