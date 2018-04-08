package id.rofiqof.assesmenttest.support;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import id.rofiqof.assesmenttest.model.User;

public class SessionData {

    private Context context;
    SharedPreferences session;
    SharedPreferences.Editor editor;

    public SessionData(Context context) {
        this.context = context;

        session = context.getSharedPreferences("session", 0);
        editor = session.edit();
    }

    public void saveUser(User data) {
        editor.putString("nama", data.getUsername());
        editor.apply();
    }

    public void isLogin(boolean action) {
        editor.putBoolean("isLogin", action);
        editor.commit();
    }

    public boolean isLogin() {
        return session.getBoolean("isLogin", false);
    }

    public void destroySession() {
        editor.clear();
        editor.commit();
    }

}
