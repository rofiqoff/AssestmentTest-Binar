package id.rofiqof.assesmenttest.view.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import id.rofiqof.assesmenttest.R;
import id.rofiqof.assesmenttest.databinding.LoginActivityBinding;
import id.rofiqof.assesmenttest.model.User;
import id.rofiqof.assesmenttest.module.login.LoginInteractor;
import id.rofiqof.assesmenttest.module.login.LoginPresenter;
import id.rofiqof.assesmenttest.module.login.LoginView;
import id.rofiqof.assesmenttest.support.SessionData;
import id.rofiqof.assesmenttest.view.home.HomeActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    LoginActivityBinding content;
    LoginPresenter presenter;

    ProgressDialog mDialog;

    SessionData session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = DataBindingUtil.setContentView(this, R.layout.login_activity);
        content.setView(this);

        mDialog = new ProgressDialog(LoginActivity.this);
        mDialog.setMessage("Please Wait ...");
        mDialog.setCancelable(false);

        session = new SessionData(LoginActivity.this);

        presenter = new LoginPresenter(new LoginInteractor(), this);

        checkEditTextEmpty(content.username);
        checkEditTextEmpty(content.password);

    }

    public void loginAction() {
        mDialog.show();
        presenter.login(
                content.username.getText().toString(),
                content.password.getText().toString());
    }

    private void checkEditTextEmpty(EditText view) {
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty()) {
                    content.buttonLogin.setEnabled(false);
                } else {
                    if (content.username.getText().toString().isEmpty()
                            || content.password.getText().toString().isEmpty()) {

                        content.buttonLogin.setEnabled(false);
                    } else {
                        content.buttonLogin.setEnabled(true);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void loginViewSuccess(User data) {
        mDialog.dismiss();
        session.isLogin(true);
        presenter.toHome(getBaseContext());
    }

    @Override
    public void loginViewFailed(String message) {
        mDialog.dismiss();
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }
}
