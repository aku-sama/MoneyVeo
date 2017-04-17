package ru.improvegroup.moneyveo.server.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.improvegroup.moneyveo.server.enums.ResultDescription;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class BasicResponse {

    @SerializedName("Result")
    private int result;

    @SerializedName("ResultDescription")
    private String resultDescription;

    @SerializedName("Reasons")
    private BasicReason[] reasons;

    @SerializedName("ModelErrors")
    private BasicModelError[] modelErrors;

    public int getResult() {
        return result;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public List<BasicReason> getReasons() {
        return new ArrayList<BasicReason>(Arrays.asList(reasons));
    }

    public BasicModelError[] getModelErrors() {
        return modelErrors;
    }

    public boolean isResponseSuccess() {
        return getResult() == ResultDescription.SUCCESS.getValue() ||
                getResult() == ResultDescription.SUCCESS_WITH_WARNING.getValue();
    }
}
