package ru.asgubin.rsr.report.chapter7;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_7_2")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_7_2 {

    @XmlElement(name = "table_7_2_1")
    private List<TableRow_7_2_1> table_7_2_1;

    protected Chapter_7_2() {
    }

    public Chapter_7_2(List<TableRow_7_2_1> table_7_2_1) {
        this.table_7_2_1 = table_7_2_1;
    }

    public List<TableRow_7_2_1> getTable_7_2_1() {
        return table_7_2_1;
    }

    public void setTable_7_2_1(List<TableRow_7_2_1> table_7_2_1) {
        this.table_7_2_1 = table_7_2_1;
    }
}
