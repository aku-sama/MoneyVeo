package ru.improvegroup.moneyveo.app;

import android.content.Context;
import android.content.SharedPreferences;

import ru.improvegroup.moneyveo.server.entity.Login;
import ru.improvegroup.moneyveo.server.entity.Token;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class Config {
    public static final String PROVIDER_TOKEN = "6e1b5406-2c9a-4892-be27-c665d59ded2c";

    private static final String PREF_FILE = "veo_prefs";

    private static final String TOKEN = "veo_token";
    private static final String LOGIN = "veo_login";
    public static final String PASSWORD = "veo_password";


    private static SharedPreferences getSharedPreferences() {
        return VeoApplication.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEditor() {
        SharedPreferences settings = getSharedPreferences();
        return settings.edit();
    }


    public static String getAuthorizationToken() {
        SharedPreferences sharedPref = getSharedPreferences();
        return sharedPref.getString(TOKEN, "");
    }



    public static void setAuthorizationToken(Token token) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(TOKEN, token.getToken());
        editor.apply();
    }

    public static void setLoginPreferences(Login login) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(LOGIN, login.getIdentifier());
        editor.putString(PASSWORD, login.getPassword());
        editor.apply();
    }


    public static Login getLoginPreferences() {
        SharedPreferences sharedPref = getSharedPreferences();

        String email = sharedPref.getString(LOGIN, "");
        String password = sharedPref.getString(PASSWORD, "");
        Login login = Login.newBuilder()
                .setPassword(password)
                .setLogin(email)
                .build();

        return login;
    }
}
