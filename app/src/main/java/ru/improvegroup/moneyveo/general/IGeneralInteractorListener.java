package ru.improvegroup.moneyveo.general;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public interface IGeneralInteractorListener {

    void onError(String message, int... code);

    void onError(int message, int... code);

}
