package ru.asgubin.rsr.report.types;

public enum EventModelType {
    REPAIRABLE(1),
    TESTED(2),
    PROBABILITY(3),
    MISSION_TIME(4),
    FREQUENCY(5),
    NON_REPAIRABLE(6);

    private final int value;

    EventModelType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
