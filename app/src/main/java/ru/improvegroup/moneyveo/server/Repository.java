package ru.improvegroup.moneyveo.server;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.improvegroup.moneyveo.R;
import ru.improvegroup.moneyveo.server.entity.BasicResponse;
import ru.improvegroup.moneyveo.server.entity.Login;
import ru.improvegroup.moneyveo.server.entity.Token;
import ru.improvegroup.moneyveo.ui.ILoginInteractor;
import ru.improvegroup.moneyveo.utils.OnlineChecker;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class Repository {

    public static void serverAuthorization(final Login loginObject, final ILoginInteractor.onLoginListener listener) {
        if (OnlineChecker.isOnline()) {
            ServerMethods.authorization(loginObject, new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    if (response.body() != null && response.body().isResponseSuccess()) {
                        listener.onLoginSuccess(response.body());
                    } else {
                        String error = ErrorWorker.getErrorMessage(response.body(), response.errorBody());
                        listener.onError(error, response.code());
                    }
                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    listener.onError(t.getLocalizedMessage());
                }
            });
        } else {
            listener.onError(R.string.http_no_internet);
        }
    }

    public static void checkProviderToken(final ILoginInteractor.onLoginListener listener) {
        if (OnlineChecker.isOnline()) {
            ServerMethods.checkProviderToken(new Callback<BasicResponse>() {
                @Override
                public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                    if (response.body() != null && response.body().isResponseSuccess()) {
                        listener.onProviderTokenChecked();
                    } else {
                        String error = ErrorWorker.getErrorMessage(response.body(), response.errorBody());
                        listener.onError(error, response.code());
                    }
                }

                @Override
                public void onFailure(Call<BasicResponse> call, Throwable t) {
                    listener.onError(t.getLocalizedMessage());
                }
            });
        } else {
            listener.onError(R.string.http_no_internet);
        }
    }
}
