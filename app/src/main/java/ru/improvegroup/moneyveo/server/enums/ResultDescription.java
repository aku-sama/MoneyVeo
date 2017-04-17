package ru.improvegroup.moneyveo.server.enums;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public enum ResultDescription {

    SUCCESS(0),
    SUCCESS_WITH_WARNING(1),
    FAILED(2);

    private final int value;

    private ResultDescription(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
