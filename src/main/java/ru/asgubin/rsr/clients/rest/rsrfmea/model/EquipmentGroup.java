package ru.asgubin.rsr.clients.rest.rsrfmea.model;

public class EquipmentGroup {

    private int id;
    private String textEng;

    protected EquipmentGroup() {
    }

    public EquipmentGroup(int id, String textEng) {
        this.id = id;
        this.textEng = textEng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextEng() {
        return textEng;
    }

    public void setTextEng(String textEng) {
        this.textEng = textEng;
    }
}
