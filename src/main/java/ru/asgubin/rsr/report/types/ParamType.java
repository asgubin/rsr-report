package ru.asgubin.rsr.report.types;

public enum ParamType {

    UNKNOWN(0),
    PROBABILITY(14),
    FAILURE_RATE(15),
    TEST_INTERVAL(18),
    MISSION_TIME(20),
    BETA_FACTOR(43),
    GAMMA_FACTOR(44),
    DELTA_FACTOR(45),
    ALPHA_2(47),
    ALPHA_3(48),
    ALPHA_4(49),
    ALPHA_5(56),
    ALPHA_6(57),
    ALPHA_7(58),
    ALPHA_8(59);


    private final int value;

    ParamType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
