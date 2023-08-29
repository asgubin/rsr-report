package ru.asgubin.rsr.report.chapter13;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "chapter_13")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_13 {

    @XmlElement(name = "conclusions")
    private List<Conclusion> conclusions;

    protected Chapter_13() {
    }

    public Chapter_13(List<Conclusion> conclusions) {
        this.conclusions = conclusions;
    }

    public List<Conclusion> getConclusions() {
        return conclusions;
    }

    public void setConclusions(List<Conclusion> conclusions) {
        this.conclusions = conclusions;
    }
}
