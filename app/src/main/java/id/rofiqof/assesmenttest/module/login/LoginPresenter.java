package id.rofiqof.assesmenttest.module.login;

import android.content.Context;
import android.content.Intent;

import id.rofiqof.assesmenttest.model.User;
import id.rofiqof.assesmenttest.view.home.HomeActivity;

public class LoginPresenter implements LoginInterface, LoginOutput {

    private LoginInteractor interactor;
    private LoginView view;

    public LoginPresenter(LoginInteractor interactor, LoginView view) {
        this.interactor = interactor;
        this.view = view;

        interactor.output = this;
    }

    @Override
    public void login(String nama, String password) {
        interactor.loginInput(nama, password);
    }

    @Override
    public void loginSuccess(User data) {
        view.loginViewSuccess(data);
    }

    @Override
    public void loginFailed(String message) {
        view.loginViewFailed(message);
    }

    @Override
    public void toHome(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(new Intent(intent));
    }
}
