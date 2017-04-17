package ru.improvegroup.moneyveo.utils;

import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import ru.improvegroup.moneyveo.app.VeoApplication;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class TextInputHelper {

    private static final int ERROR_SHOW_TIMEOUT = 5000;

    public static void showError(final TextInputLayout layout, final int stringId) {
        layout.setErrorEnabled(true);
        layout.setError(VeoApplication.getInstance().getString(stringId));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                layout.setError("");
            }
        }, ERROR_SHOW_TIMEOUT);

        layout.requestFocus();
    }

    public static String getValue(final TextInputLayout layout) {
        EditText edit = layout.getEditText();
        if (edit != null) {
            return layout.getEditText().getText().toString();
        }

        return "";
    }
}
