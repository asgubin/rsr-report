package ru.asgubin.rsr.report.chapter12;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.asgubin.rsr.rsrresultdb.UncsSummary;

@XmlRootElement(name = "chapter_12_1_2")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_12_1_2 {

    private UncsSummary uncsSummary;

    public Chapter_12_1_2() {
    }

    public Chapter_12_1_2(UncsSummary uncsSummary) {
        this.uncsSummary = uncsSummary;
    }

    public UncsSummary getUncsSummary() {
        return uncsSummary;
    }

    public void setUncsSummary(UncsSummary uncsSummary) {
        this.uncsSummary = uncsSummary;
    }
}
