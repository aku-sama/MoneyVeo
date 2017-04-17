package ru.improvegroup.moneyveo.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.improvegroup.moneyveo.R;
import ru.improvegroup.moneyveo.general.GeneralActivity;
import ru.improvegroup.moneyveo.utils.TextInputHelper;

public class LoginActivity extends GeneralActivity<ILoginView, LoginPresenter> implements ILoginView {

    @BindView(R.id.emailLayout)
    TextInputLayout emailLayout;
    @BindView(R.id.passwordLayout)
    TextInputLayout passwordLayout;
    @BindView(R.id.loginButton)
    Button loginButton;
    @BindView(R.id.registerButton)
    Button registerButton;
    @BindView(R.id.forgotPasswordButton)
    Button forgotPasswordButton;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        passwordLayout.getEditText().setOnEditorActionListener(new MyEditorTextListener());

        setupToolbar();
    }

    @SuppressWarnings("deprecation")
    private void setupToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back));
        getSupportActionBar().setElevation(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_presets:
                presetLoginValues();
                return true;
            case R.id.menu_clear:
                clearLoginValues();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void clearLoginValues() {
        emailLayout.getEditText().setText("");
        passwordLayout.getEditText().setText("");
    }


    private void presetLoginValues() {
        emailLayout.getEditText().setText("firefox_10fba036b5ea4a7e9959dc6f2c6929b4_9@mv.ua");
        passwordLayout.getEditText().setText("12345aQ");
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @OnClick(R.id.loginButton)
    void onLoginClick() {
        presenter.login(TextInputHelper.getValue(emailLayout), TextInputHelper.getValue(passwordLayout));
    }

    @OnClick(R.id.forgotPasswordButton)
    void onForgetClick() {
        presenter.forgetPassword();
    }

    @Override
    public void showProgress() {
        showProgressView();
    }

    @Override
    public void hideProgress() {
        hideProgressView();
    }

    @Override
    public void showError(String message, int... code) {
        showErrorSnackBar(message);
    }

    @Override
    public void showError(int message, int... code) {
        showErrorSnackBar(message);

    }

    @Override
    public void showEmailValidationError(int errorId) {
        TextInputHelper.showError(emailLayout, errorId);
    }

    @Override
    public void showPasswordValidationError(int errorId) {
        TextInputHelper.showError(passwordLayout, errorId);
    }

    @Override
    public void onSignInSuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.login_aler_header)
                .setMessage(R.string.login_dialog_success_message)
                .setPositiveButton(R.string.dialog_ok, null)
                .create()
                .show();
    }

    @Override
    public void goToPasswordRecovery() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.login_aler_header)
                .setMessage(R.string.login_dialog_forget_message)
                .setPositiveButton(R.string.dialog_ok, null)
                .create()
                .show();
    }

    @OnClick(R.id.registerButton)
    @Override
    public void goToRegistration() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.no_reg_title)
                .setMessage(R.string.no_reg_message)
                .setPositiveButton(R.string.dialog_ok, null)
                .create()
                .show();
    }

    private class MyEditorTextListener implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                onLoginClick();
            }
            return handled;
        }
    }

}
