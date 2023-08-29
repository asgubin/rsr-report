package ru.asgubin.rsr.clients.rest.rsrdb.model;

import java.util.Date;

public class CcfGroup {
    private short type;
    private int num;
    private String id;
    private String Text;
    private short tag;
    private short ccfModel;
    private Date editDate;
    private int editUid;
    private Date reviewDate;
    private int reviewUid;
    private Date approvedDate;
    private int approvedUid;
    private boolean flag;
    private int ccfAlpha8Bound;

    public CcfGroup() {
    }

    public CcfGroup(short type, int num, String id, String text, short tag,
                    short ccfModel, Date editDate, int editUid, Date reviewDate,
                    int reviewUid, Date approvedDate, int approvedUid,
                    boolean flag, int ccfAlpha8Bound) {
        this.type = type;
        this.num = num;
        this.id = id;
        Text = text;
        this.tag = tag;
        this.ccfModel = ccfModel;
        this.editDate = editDate;
        this.editUid = editUid;
        this.reviewDate = reviewDate;
        this.reviewUid = reviewUid;
        this.approvedDate = approvedDate;
        this.approvedUid = approvedUid;
        this.flag = flag;
        this.ccfAlpha8Bound = ccfAlpha8Bound;
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
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public short getTag() {
        return tag;
    }

    public void setTag(short tag) {
        this.tag = tag;
    }

    public short getCcfModel() {
        return ccfModel;
    }

    public void setCcfModel(short ccfModel) {
        this.ccfModel = ccfModel;
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

    public int getCcfAlpha8Bound() {
        return ccfAlpha8Bound;
    }

    public void setCcfAlpha8Bound(int ccfAlpha8Bound) {
        this.ccfAlpha8Bound = ccfAlpha8Bound;
    }
}
