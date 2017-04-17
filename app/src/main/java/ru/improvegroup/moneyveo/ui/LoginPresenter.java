package ru.improvegroup.moneyveo.ui;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import ru.improvegroup.moneyveo.R;
import ru.improvegroup.moneyveo.server.entity.Login;
import ru.improvegroup.moneyveo.server.entity.Token;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

class LoginPresenter extends MvpBasePresenter<ILoginView> implements ILoginInteractor.onLoginListener {

    private ILoginInteractor interactor;

    LoginPresenter() {
        interactor = new LoginInteractor();
    }

    void forgetPassword() {
        getView().goToPasswordRecovery();
    }

    void login(String email, String password) {
        if (validate(email, password)) {
            getView().showProgress();

            Login login = Login.newBuilder()
                    .setLogin(email)
                    .setPassword(password)
                    .build();

            interactor.login(login, this);
        }
    }

    private boolean validate(String email, String password) {

        if (email.isEmpty()) {
            getView().showEmailValidationError(R.string.login_error_field_empty);
            return false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            getView().showEmailValidationError(R.string.login_error_email_wrong);
            return false;
        } else if (password.isEmpty()) {
            getView().showPasswordValidationError(R.string.login_error_field_empty);
            return false;
        } else if (password.length() < 6 || notContainsNumbers(password)) {
            getView().showPasswordValidationError(R.string.login_error_password);
            return false;
        }
        return true;
    }


    private static boolean notContainsNumbers(String str) {
        if (str == null)
            return true;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onError(String message, int... code) {
        getView().hideProgress();
        getView().showError(message, code);
    }

    @Override
    public void onError(int message, int... code) {
        getView().hideProgress();
        getView().showError(message, code);
    }

    @Override
    public void onProviderTokenChecked() {
        //do nothing
    }

    @Override
    public void onLoginSuccess(Token token) {
        getView().hideProgress();
        getView().onSignInSuccess();
    }
}
