package ru.improvegroup.moneyveo.ui.main;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.improvegroup.moneyveo.R;
import ru.improvegroup.moneyveo.general.GeneralActivity;
import ru.improvegroup.moneyveo.ui.LoginActivity;

/**
 * Created by Diana.Raspopova on 4/17/2017.
 */

public class MainActivity extends GeneralActivity<IMainView, MainPresenter> implements IMainView {

    @BindView(R.id.registerButton)
    Button registerButton;
    @BindView(R.id.loginButton)
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
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

    @OnClick(R.id.loginButton)
    @Override
    public void goToSignIn() {
        startActivity(LoginActivity.class);
    }


}
