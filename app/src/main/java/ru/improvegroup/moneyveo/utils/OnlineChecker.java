package ru.improvegroup.moneyveo.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import ru.improvegroup.moneyveo.app.VeoApplication;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class OnlineChecker {

    public static boolean isOnline() {
        try {
            ConnectivityManager cm = (ConnectivityManager) VeoApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception e) {
            return false;
        }
    }
}
