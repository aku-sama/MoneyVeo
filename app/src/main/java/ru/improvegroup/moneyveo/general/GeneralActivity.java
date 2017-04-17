package ru.improvegroup.moneyveo.general;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import ru.improvegroup.moneyveo.R;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public abstract class GeneralActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> {
    ProgressDialog progress;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showProgressView() {
        boolean progressDialogExist = progress != null && progress.isShowing();
        if (!progressDialogExist)
            progress = ProgressDialog.show(this, null,
                    getString(R.string.progress_text), true);

    }

    public void hideProgressView() {
        if (progress != null)
            progress.dismiss();

    }

    public void showErrorSnackBar(int messageId) {
        showErrorSnackBar(getString(messageId));
    }

    public void showErrorSnackBar(String message) {
        final View viewGroup = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);

        Snackbar snackbar = Snackbar
                .make(viewGroup, message, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.snack_bar_button, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

        // Change background color
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        // Changing message text color
        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        textView.setMaxLines(10);
        snackbar.show();
    }

    protected void startActivity(Class activityClass) {
        startActivity(activityClass, false);
    }

    protected void startActivity(Class activityClass, boolean lockBackAction) {
        Intent intent = new Intent(this, activityClass);
        if (lockBackAction) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        startActivity(intent);
    }

}
