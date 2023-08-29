package ru.asgubin.rsr.report.chapter8;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_8_2")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_8_2 {

    @XmlElement(name = "table_8_2_1")
    List<TableRow_8_2_1> table_8_2_1;

    public Chapter_8_2() {
    }

    public Chapter_8_2(List<TableRow_8_2_1> table_8_2_1) {
        this.table_8_2_1 = table_8_2_1;
    }

    public List<TableRow_8_2_1> getTable_8_2_1() {
        return table_8_2_1;
    }

    public void setTable_8_2_1(List<TableRow_8_2_1> table_8_2_1) {
        this.table_8_2_1 = table_8_2_1;
    }
}
