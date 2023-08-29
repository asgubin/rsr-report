package ru.asgubin.rsr.report.chapter8;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_8_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_8_1 {

    @XmlElement(name = "table_8_1_1")
    private List<TableRow_8_1_1> table_8_1_1;

    protected Chapter_8_1() {
    }

    public Chapter_8_1(List<TableRow_8_1_1> table_8_1_1) {
        this.table_8_1_1 = table_8_1_1;
    }

    public List<TableRow_8_1_1> getTable_8_1_1() {
        return table_8_1_1;
    }

    public void setTable_8_1_1(List<TableRow_8_1_1> table_8_1_1) {
        this.table_8_1_1 = table_8_1_1;
    }
}
