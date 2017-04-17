package ru.improvegroup.moneyveo.app;

import android.app.Application;

import ru.improvegroup.moneyveo.server.RetrofitService;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class VeoApplication extends Application {

    private static VeoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        initRetrofit();
    }

    public static VeoApplication getInstance() {
        return instance;
    }

    private void initRetrofit() {
        RetrofitService.init();
    }
}
