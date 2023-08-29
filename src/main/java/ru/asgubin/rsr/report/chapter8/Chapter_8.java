package ru.asgubin.rsr.report.chapter8;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chapter_8")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_8 {

    private Chapter_8_1 chapter_8_1;
    private Chapter_8_2 chapter_8_2;

    protected Chapter_8() {
    }

    public Chapter_8(Chapter_8_1 chapter_8_1, Chapter_8_2 chapter_8_2) {
        this.chapter_8_1 = chapter_8_1;
        this.chapter_8_2 = chapter_8_2;
    }

    public Chapter_8_1 getChapter_8_1() {
        return chapter_8_1;
    }

    public void setChapter_8_1(Chapter_8_1 chapter_8_1) {
        this.chapter_8_1 = chapter_8_1;
    }

    public Chapter_8_2 getChapter_8_2() {
        return chapter_8_2;
    }

    public void setChapter_8_2(Chapter_8_2 chapter_8_2) {
        this.chapter_8_2 = chapter_8_2;
    }
}
