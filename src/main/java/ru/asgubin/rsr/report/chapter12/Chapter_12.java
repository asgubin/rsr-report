package ru.asgubin.rsr.report.chapter12;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_12")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_12 {

    @XmlElement(name = "chapter_12_1s")
    private List<Chapter_12_1> chapter_12_1s;

    protected Chapter_12() {
    }

    public Chapter_12(List<Chapter_12_1> chapter_12_1s) {
        this.chapter_12_1s = chapter_12_1s;
    }

    public List<Chapter_12_1> getChapter_12_1s() {
        return chapter_12_1s;
    }

    public void setChapter_12_1s(List<Chapter_12_1> chapter_12_1s) {
        this.chapter_12_1s = chapter_12_1s;
    }
}
