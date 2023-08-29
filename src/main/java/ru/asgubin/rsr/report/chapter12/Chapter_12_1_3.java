package ru.asgubin.rsr.report.chapter12;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.asgubin.rsr.rsrresultdb.BeImp;

import java.util.List;

@XmlRootElement(name = "chapter_12_1_3")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_12_1_3 {

    @XmlElement(name = "beImp")
    private List<BeImp> beImpList;

    protected Chapter_12_1_3() {

    }

    public Chapter_12_1_3(List<BeImp> beImpList) {
        this.beImpList = beImpList;
    }

    public List<BeImp> getBeImpList() {
        return beImpList;
    }

    public void setBeImpList(List<BeImp> beImpList) {
        this.beImpList = beImpList;
    }
}
