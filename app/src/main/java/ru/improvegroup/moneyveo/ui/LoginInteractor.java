package ru.improvegroup.moneyveo.ui;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.improvegroup.moneyveo.R;
import ru.improvegroup.moneyveo.app.Config;
import ru.improvegroup.moneyveo.server.ErrorWorker;
import ru.improvegroup.moneyveo.server.Repository;
import ru.improvegroup.moneyveo.server.ServerMethods;
import ru.improvegroup.moneyveo.server.entity.BasicResponse;
import ru.improvegroup.moneyveo.server.entity.Login;
import ru.improvegroup.moneyveo.server.entity.Token;
import ru.improvegroup.moneyveo.utils.OnlineChecker;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

class LoginInteractor implements ILoginInteractor {

    @Override
    public void login(final Login loginObject, final onLoginListener listener) {
        Repository.checkProviderToken(new onLoginListener() {
            @Override
            public void onProviderTokenChecked() {
                serverAuthorization(loginObject, listener);

            }

            @Override
            public void onLoginSuccess(Token token) {

            }

            @Override
            public void onError(String message, int... code) {
                listener.onError(message, code);

            }

            @Override
            public void onError(int message, int... code) {
                listener.onError(message, code);

            }
        });

    }

    private void serverAuthorization(final Login loginObject, final onLoginListener listener) {
        Repository.serverAuthorization(loginObject, new onLoginListener() {
            @Override
            public void onProviderTokenChecked() {

            }

            @Override
            public void onLoginSuccess(Token token) {
                Config.setLoginPreferences(loginObject);
                Config.setAuthorizationToken(token);
                listener.onLoginSuccess(token);
            }

            @Override
            public void onError(String message, int... code) {
                listener.onError(message, code);
            }

            @Override
            public void onError(int message, int... code) {
                listener.onError(message, code);
            }
        });
    }


}
