package ru.improvegroup.moneyveo.ui.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;

import ru.improvegroup.moneyveo.R;
import ru.improvegroup.moneyveo.general.GeneralActivity;
import ru.improvegroup.moneyveo.ui.main.MainActivity;


/**
 * Created by Diana.Raspopova on 4/17/2017.
 */

public class SplashActivity extends GeneralActivity<ISplashView, SplashPresenter> implements ISplashView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @NonNull
    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.initialize();
    }

    @Override
    public void goNextScreen() {
        startActivity(MainActivity.class, true);
    }
}
