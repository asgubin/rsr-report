package ru.asgubin.rsr.report.types;

public enum EventType {
    BASIC_EVENTS(5),
    BE_GATE(6),
    CCF_EVENTS(12),
    CCF_E_GATE(21);

    private final int value;

    EventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
