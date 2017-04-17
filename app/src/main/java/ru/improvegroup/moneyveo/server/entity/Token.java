package ru.improvegroup.moneyveo.server.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class Token extends BasicResponse {

    @SerializedName("Token")
    private String token;

    @SerializedName("FailedAuthCount")
    private int failedAuthCount;

    public String getToken() {
        return token;
    }

    public int getFailedAuthCount() {
        return failedAuthCount;
    }
}
