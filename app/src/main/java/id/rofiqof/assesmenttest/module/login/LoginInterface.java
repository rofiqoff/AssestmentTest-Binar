package id.rofiqof.assesmenttest.module.login;

import android.content.Context;

import id.rofiqof.assesmenttest.model.User;

interface LoginInterface {
    void login(String nama, String password);
}

interface LoginInput {
    void loginInput(String nama, String password);
}

interface LoginOutput {
    void loginSuccess(User data);
    void loginFailed(String message);
    void toHome(Context context);
}

