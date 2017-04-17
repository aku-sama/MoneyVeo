package ru.improvegroup.moneyveo.ui.splash;

import android.os.Handler;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;


/**
 * Created by Diana.Raspopova on 4/17/2017.
 */

public class SplashPresenter extends MvpBasePresenter<ISplashView> {

    public static final int SPLASH_DEFAULT_DELAY = 1500;

    void initialize() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().goNextScreen();
            }
        }, SPLASH_DEFAULT_DELAY);
    }
}
