package ru.asgubin.rsr.report.types;

public enum EventSuffixType {
    HE("-HE"),
    HUM("-HUM"),
    M("-M"),

    ATC("ATC"),
    U("-U"),
    C("-C"),
    Q("-Q"),
    S("-S"),
    O("-O"),
    V("-V"),
    K("-K"),
    A("-A"),
    H("-H"),
    R("-R"),
    E("-E"),
    L("-L"),

    F1("-F1"),
    F2("-F2"),
    F3("-F3");

    private final String postfix;

    EventSuffixType(String postfix) {
        this.postfix = postfix;
    }

    public String getPostfix() {
        return postfix;
    }
}
