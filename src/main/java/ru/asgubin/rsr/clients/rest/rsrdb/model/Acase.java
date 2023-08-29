package ru.asgubin.rsr.clients.rest.rsrdb.model;

import java.util.Date;

public class Acase {

    private short type;
    private int num;
    private String id;
    private String text;
    private short tag;
    private short resType;
    private double mean;
    private double p05;
    private double p95;
    private short textRes;
    private short geRes;
    private short beRes;
    private short exchRes;
    private short unit;
    private Date editDate;
    private int editUid;
    private Date reviewDate;
    private int reviewUid;
    private Date approvedDate;
    private int approvedUid;
    private boolean flag;

    public Acase() {
    }

    public Acase(short type, int num, String id, String text, short tag, short resType,
                 double mean, double p05, double p95, short textRes, short geRes, short beRes,
                 short exchRes, short unit, Date editDate, int editUid, Date reviewDate,
                 int reviewUid, Date approvedDate, int approvedUid, boolean flag) {
        this.type = type;
        this.num = num;
        this.id = id;
        this.text = text;
        this.tag = tag;
        this.resType = resType;
        this.mean = mean;
        this.p05 = p05;
        this.p95 = p95;
        this.textRes = textRes;
        this.geRes = geRes;
        this.beRes = beRes;
        this.exchRes = exchRes;
        this.unit = unit;
        this.editDate = editDate;
        this.editUid = editUid;
        this.reviewDate = reviewDate;
        this.reviewUid = reviewUid;
        this.approvedDate = approvedDate;
        this.approvedUid = approvedUid;
        this.flag = flag;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public short getTag() {
        return tag;
    }

    public void setTag(short tag) {
        this.tag = tag;
    }

    public short getResType() {
        return resType;
    }

    public void setResType(short resType) {
        this.resType = resType;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getP05() {
        return p05;
    }

    public void setP05(double p05) {
        this.p05 = p05;
    }

    public double getP95() {
        return p95;
    }

    public void setP95(double p95) {
        this.p95 = p95;
    }

    public short getTextRes() {
        return textRes;
    }

    public void setTextRes(short textRes) {
        this.textRes = textRes;
    }

    public short getGeRes() {
        return geRes;
    }

    public void setGeRes(short geRes) {
        this.geRes = geRes;
    }

    public short getBeRes() {
        return beRes;
    }

    public void setBeRes(short beRes) {
        this.beRes = beRes;
    }

    public short getExchRes() {
        return exchRes;
    }

    public void setExchRes(short exchRes) {
        this.exchRes = exchRes;
    }

    public short getUnit() {
        return unit;
    }

    public void setUnit(short unit) {
        this.unit = unit;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getEditUid() {
        return editUid;
    }

    public void setEditUid(int editUid) {
        this.editUid = editUid;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getReviewUid() {
        return reviewUid;
    }

    public void setReviewUid(int reviewUid) {
        this.reviewUid = reviewUid;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public int getApprovedUid() {
        return approvedUid;
    }

    public void setApprovedUid(int approvedUid) {
        this.approvedUid = approvedUid;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
