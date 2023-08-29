package ru.asgubin.rsr.report.chapter7;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chapter_7")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter_7 {

    private Chapter_7_1 chapter_7_1;

    private Chapter_7_2 chapter_7_2;

    protected Chapter_7() {
    }

    public Chapter_7(Chapter_7_1 chapter_7_1, Chapter_7_2 chapter_7_2) {
        this.chapter_7_1 = chapter_7_1;
        this.chapter_7_2 = chapter_7_2;
    }

    public Chapter_7_1 getChapter_7_1() {
        return chapter_7_1;
    }

    public void setChapter_7_1(Chapter_7_1 chapter_7_1) {
        this.chapter_7_1 = chapter_7_1;
    }

    public Chapter_7_2 getChapter_7_2() {
        return chapter_7_2;
    }

    public void setChapter_7_2(Chapter_7_2 chapter_7_2) {
        this.chapter_7_2 = chapter_7_2;
    }
}
