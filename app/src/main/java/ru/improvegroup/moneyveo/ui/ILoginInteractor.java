package ru.improvegroup.moneyveo.ui;

import ru.improvegroup.moneyveo.general.IGeneralInteractorListener;
import ru.improvegroup.moneyveo.server.entity.Login;
import ru.improvegroup.moneyveo.server.entity.Token;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public interface ILoginInteractor {

    interface onLoginListener extends IGeneralInteractorListener {
        void onProviderTokenChecked();

        void onLoginSuccess(Token token);
    }

    void login(Login loginObject, onLoginListener listener);

}
