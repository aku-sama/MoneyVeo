package ru.improvegroup.moneyveo.server.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class BasicModelError {

    @SerializedName("Field")
    private String field;

    @SerializedName("Errors")
    private String[] errors;

    public String getField() {
        return field;
    }

    public String[] getErrors() {
        return errors;
    }
}
