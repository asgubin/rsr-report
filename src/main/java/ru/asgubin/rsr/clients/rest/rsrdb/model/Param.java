package ru.asgubin.rsr.clients.rest.rsrdb.model;

import ru.asgubin.rsr.report.chapter6.pojo.EqKks;

import java.util.Date;

public class Param {
    private short type;
    private int num;
    private String id;
    private String text;
    private short tag;
    private float mean;
    private short distType;
    private float distPar1;
    private float distPar2;
    private float distPar3;
    private short unit;
    private float median;
    private float p05;
    private float p95;
    private float varCoeff;
    private Date editDate;
    private int editUid;
    private Date reviewDate;
    private int reviewUid;
    private Date approvedDate;
    private int approvedUid;
    private boolean flag;

    public Param() {
    }

    public Param(short type, int num, String id, String text, short tag,
                 float mean, short distType, float distPar1, float distPar2,
                 float distPar3, short unit, float median, float p05, float p95,
                 float varCoeff, Date editDate, int editUid, Date reviewDate,
                 int reviewUid, Date approvedDate, int approvedUid, boolean flag) {
        this.type = type;
        this.num = num;
        this.id = id;
        this.text = text;
        this.tag = tag;
        this.mean = mean;
        this.distType = distType;
        this.distPar1 = distPar1;
        this.distPar2 = distPar2;
        this.distPar3 = distPar3;
        this.unit = unit;
        this.median = median;
        this.p05 = p05;
        this.p95 = p95;
        this.varCoeff = varCoeff;
        this.editDate = editDate;
        this.editUid = editUid;
        this.reviewDate = reviewDate;
        this.reviewUid = reviewUid;
        this.approvedDate = approvedDate;
        this.approvedUid = approvedUid;
        this.flag = flag;
    }

    @Override
    public int hashCode() {
        return 31 * this.num + this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Param)) {
            return false;
        }
        Param other = (Param) o;
        return (this.id == null && other.id == null)
                || (this.id != null && this.id.equals(other.id));
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

    public float getMean() {
        return mean;
    }

    public void setMean(float mean) {
        this.mean = mean;
    }

    public short getDistType() {
        return distType;
    }

    public void setDistType(short distType) {
        this.distType = distType;
    }

    public float getDistPar1() {
        return distPar1;
    }

    public void setDistPar1(float distPar1) {
        this.distPar1 = distPar1;
    }

    public float getDistPar2() {
        return distPar2;
    }

    public void setDistPar2(float distPar2) {
        this.distPar2 = distPar2;
    }

    public float getDistPar3() {
        return distPar3;
    }

    public void setDistPar3(float distPar3) {
        this.distPar3 = distPar3;
    }

    public short getUnit() {
        return unit;
    }

    public void setUnit(short unit) {
        this.unit = unit;
    }

    public float getMedian() {
        return median;
    }

    public void setMedian(float median) {
        this.median = median;
    }

    public float getP05() {
        return p05;
    }

    public void setP05(float p05) {
        this.p05 = p05;
    }

    public float getP95() {
        return p95;
    }

    public void setP95(float p95) {
        this.p95 = p95;
    }

    public float getVarCoeff() {
        return varCoeff;
    }

    public void setVarCoeff(float varCoeff) {
        this.varCoeff = varCoeff;
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
