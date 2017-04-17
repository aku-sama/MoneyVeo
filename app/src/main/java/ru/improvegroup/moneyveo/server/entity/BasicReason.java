package ru.improvegroup.moneyveo.server.entity;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class BasicReason {

    @SerializedName("Code")
    private
    String code;
    @SerializedName("CodeDescription")
    private String codeDescription;

    @Nullable
    @SerializedName("Details")
    private
    String details;

    public String getCode() {
        return code;
    }

    public String getCodeDescription() {
        return codeDescription;
    }

    @Nullable
    public String getDetails() {
        return details;
    }
}
