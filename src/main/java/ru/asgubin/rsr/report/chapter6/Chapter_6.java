package ru.asgubin.rsr.report.chapter6;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chapter_6")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_6 {

    private Chapter_6_1 chapter_6_1;
    private Chapter_6_2 chapter_6_2;

    protected Chapter_6() {
    }

    public Chapter_6(Chapter_6_2 chapter_6_2) {
        this.chapter_6_2 = chapter_6_2;
    }

    public Chapter_6(Chapter_6_1 chapter_6_1, Chapter_6_2 chapter_6_2) {
        this.chapter_6_1 = chapter_6_1;
        this.chapter_6_2 = chapter_6_2;
    }

    public Chapter_6_1 getChapter_6_1() {
        return chapter_6_1;
    }

    public void setChapter_6_1(Chapter_6_1 chapter_6_1) {
        this.chapter_6_1 = chapter_6_1;
    }

    public Chapter_6_2 getChapter_6_2() {
        return chapter_6_2;
    }

    public void setChapter_6_2(Chapter_6_2 chapter_6_2) {
        this.chapter_6_2 = chapter_6_2;
    }
}
