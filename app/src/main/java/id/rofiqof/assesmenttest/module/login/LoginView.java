package id.rofiqof.assesmenttest.module.login;

import id.rofiqof.assesmenttest.model.User;

public interface LoginView {
    void loginViewSuccess(User data);
    void loginViewFailed(String message);
}
