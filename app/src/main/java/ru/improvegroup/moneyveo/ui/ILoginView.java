package ru.improvegroup.moneyveo.ui;

import ru.improvegroup.moneyveo.general.IGeneralView;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public interface ILoginView extends IGeneralView {

    void showEmailValidationError(int errorId);

    void showPasswordValidationError(int errorId);

    void onSignInSuccess();

    void goToPasswordRecovery();

    void goToRegistration();
}
