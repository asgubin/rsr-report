package ru.asgubin.rsr.report.chapter12;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_12_1_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_12_1_1 {

    private String qBestApprox;

    @XmlElement(name = "table_12_1_1_1")
    private List<TableRow_12_1_1_1> table_12_1_1_1;

    public Chapter_12_1_1() {
    }

    public Chapter_12_1_1(String qBestApprox, List<TableRow_12_1_1_1> table_12_1_1_1) {
        this.qBestApprox = qBestApprox;
        this.table_12_1_1_1 = table_12_1_1_1;
    }

    public String getqBestApprox() {
        return qBestApprox;
    }

    public void setqBestApprox(String qBestApprox) {
        this.qBestApprox = qBestApprox;
    }

    public List<TableRow_12_1_1_1> getTable_12_1_1_1() {
        return table_12_1_1_1;
    }

    public void setTable_12_1_1_1(List<TableRow_12_1_1_1> table_12_1_1_1) {
        this.table_12_1_1_1 = table_12_1_1_1;
    }
}
