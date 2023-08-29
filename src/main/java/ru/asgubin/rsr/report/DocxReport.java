package ru.asgubin.rsr.report;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.asgubin.rsr.report.chapter10.Chapter_10;
import ru.asgubin.rsr.report.chapter12.Chapter_12;
import ru.asgubin.rsr.report.chapter13.Chapter_13;
import ru.asgubin.rsr.report.chapter6.Chapter_6;
import ru.asgubin.rsr.report.chapter7.Chapter_7;
import ru.asgubin.rsr.report.chapter8.Chapter_8;

@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.FIELD)
public class DocxReport {

    private Chapter_6 chapter6;
    private Chapter_7 chapter7;
    private Chapter_8 chapter8;
    private Chapter_10 chapter10;
    private Chapter_12 chapter12;
    private Chapter_13 chapter13;

    private DocxReport(){
    }

    private DocxReport(ReportBuilder builder) {
        this.chapter6 = builder.chapter6;
        this.chapter7 = builder.chapter7;
        this.chapter8 = builder.chapter8;
        this.chapter10 = builder.chapter10;
        this.chapter12 = builder.chapter12;
        this.chapter13 = builder.chapter13;
    }

    public static class ReportBuilder {

        private Chapter_6 chapter6;
        private Chapter_7 chapter7;
        private Chapter_8 chapter8;
        private Chapter_10 chapter10;
        private Chapter_12 chapter12;
        private Chapter_13 chapter13;

        public ReportBuilder withChapter6(Chapter_6 chapter6) {
            this.chapter6 = chapter6;
            return this;
        }

        public ReportBuilder withChapter7(Chapter_7 chapter7) {
            this.chapter7 = chapter7;
            return this;
        }

        public ReportBuilder withChapter8(Chapter_8 chapter8) {
            this.chapter8 = chapter8;
            return this;
        }

        public ReportBuilder withChapter10(Chapter_10 chapter10) {
            this.chapter10 = chapter10;
            return this;
        }

        public ReportBuilder withChapter12(Chapter_12 chapter12) {
            this.chapter12 = chapter12;
            return this;
        }

        public ReportBuilder withChapter13(Chapter_13 chapter13) {
            this.chapter13 = chapter13;
            return this;
        }

        public DocxReport build() {
            return new DocxReport(this);
        }
    }

    public Chapter_6 getChapter6() {
        return chapter6;
    }

    public Chapter_7 getChapter7() {
        return chapter7;
    }

    public Chapter_8 getChapter8() {
        return chapter8;
    }

    public Chapter_10 getChapter10() {
        return chapter10;
    }

    public Chapter_12 getChapter12() {
        return chapter12;
    }

    public Chapter_13 getChapter13() {
        return chapter13;
    }
}
