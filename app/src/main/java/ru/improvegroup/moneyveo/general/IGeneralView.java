package ru.improvegroup.moneyveo.general;


import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public interface IGeneralView extends MvpView {

    void showProgress();

    void hideProgress();

    void showError(String message, int... code);

    void showError(int message, int... code);

}
