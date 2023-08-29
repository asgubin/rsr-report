package ru.asgubin.rsr.report.chapter6.pojo;

public class MissionTime {
    private String missionTime;

    public MissionTime() {
    }

    public MissionTime(String missionTime) {
        this.missionTime = missionTime;
    }

    @Override
    public int hashCode() {
        return this.missionTime.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MissionTime)) {
            return false;
        }
        MissionTime other = (MissionTime) o;
        return (this.missionTime == null && other.missionTime == null)
                || (this.missionTime != null && this.missionTime.equals(other.missionTime));
    }

    public String getMissionTime() {
        return missionTime;
    }

    public void setMissionTime(String missionTime) {
        this.missionTime = missionTime;
    }
}
