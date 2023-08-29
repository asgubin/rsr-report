package ru.asgubin.rsr.report.chapter12;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "chapter_12_1")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_12_1 {

    private String funcId;
    private String funcText;

    private Chapter_12_1_1 chapter_12_1_1;
    private Chapter_12_1_2 chapter_12_1_2;
    private Chapter_12_1_3 chapter_12_1_3;

    @XmlTransient
    private String rsrResultFile;
    @XmlTransient
    private String rsrDbName;

    protected Chapter_12_1() {
    }

    public Chapter_12_1(String funcId, String funcText,
                        Chapter_12_1_1 chapter_12_1_1,
                        Chapter_12_1_2 chapter_12_1_2,
                        Chapter_12_1_3 chapter_12_1_3,
                        String rsrResultFile,
                        String rsrDbName) {

        this.funcId = funcId;
        this.funcText = funcText;
        this.chapter_12_1_1 = chapter_12_1_1;
        this.chapter_12_1_2 = chapter_12_1_2;
        this.chapter_12_1_3 = chapter_12_1_3;

        this.rsrResultFile = rsrResultFile;
        this.rsrDbName = rsrDbName;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncText() {
        return funcText;
    }

    public void setFuncText(String funcText) {
        this.funcText = funcText;
    }

    public Chapter_12_1_1 getChapter_12_1_1() {
        return chapter_12_1_1;
    }

    public void setChapter_12_1_1(Chapter_12_1_1 chapter_12_1_1) {
        this.chapter_12_1_1 = chapter_12_1_1;
    }

    public Chapter_12_1_2 getChapter_12_1_2() {
        return chapter_12_1_2;
    }

    public void setChapter_12_1_2(Chapter_12_1_2 chapter_12_1_2) {
        this.chapter_12_1_2 = chapter_12_1_2;
    }

    public Chapter_12_1_3 getChapter_12_1_3() {
        return chapter_12_1_3;
    }

    public void setChapter_12_1_3(Chapter_12_1_3 chapter_12_1_3) {
        this.chapter_12_1_3 = chapter_12_1_3;
    }

    public String getRsrResultFile() {
        return rsrResultFile;
    }

    public String getRsrDbName() {
        return rsrDbName;
    }
}
