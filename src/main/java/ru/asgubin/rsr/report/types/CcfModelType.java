package ru.asgubin.rsr.report.types;

public enum CcfModelType {
    UNKNOWN(0),
    BETA(1),
    MGL(2),
    ALPHA_4(3),
    ALPHA_4_STAGGERED(5),
    ALPHA_8(6),
    ALPHA_8_STAGGERED(12);

    private final int value;

    CcfModelType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
