package ru.asgubin.rsr.clients.rest.rsrfmea.model;

import java.util.Date;

public class Equipment {
    private int id;
    private String descEng;
    private String kks;
    private int system;
    private String location;
    private String exclude;
    private String descRus;
    private boolean notExist;
    private Date updateDate;
    private int equipmentGroup;
    private String type;
    private String eqClass;

    protected Equipment() {
    }

    public Equipment(int id, String descEng, String kks, int system,
                     String location, String exclude, String descRus,
                     boolean notExist, Date updateDate, int equipmentGroup,
                     String type, String eqClass) {
        this.id = id;
        this.descEng = descEng;
        this.kks = kks;
        this.system = system;
        this.location = location;
        this.exclude = exclude;
        this.descRus = descRus;
        this.notExist = notExist;
        this.updateDate = updateDate;
        this.equipmentGroup = equipmentGroup;
        this.type = type;
        this.eqClass = eqClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescEng() {
        return descEng;
    }

    public void setDescEng(String descEng) {
        this.descEng = descEng;
    }

    public String getKks() {
        return kks;
    }

    public void setKks(String kks) {
        this.kks = kks;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public String getDescRus() {
        return descRus;
    }

    public void setDescRus(String descRus) {
        this.descRus = descRus;
    }

    public boolean getNotExist() {
        return notExist;
    }

    public void setNotExist(boolean notExist) {
        this.notExist = notExist;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getEquipmentGroup() {
        return equipmentGroup;
    }

    public void setEquipmentGroup(int equipmentGroup) {
        this.equipmentGroup = equipmentGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEqClass() {
        return eqClass;
    }

    public void setEqClass(String eqClass) {
        this.eqClass = eqClass;
    }
}
