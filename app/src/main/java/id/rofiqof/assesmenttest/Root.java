package id.rofiqof.assesmenttest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.rofiqof.assesmenttest.support.SessionData;
import id.rofiqof.assesmenttest.view.home.HomeActivity;
import id.rofiqof.assesmenttest.view.login.LoginActivity;

public class Root extends AppCompatActivity {

    SessionData session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root);

        session = new SessionData(this);

        if (session.isLogin()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getBaseContext(), HomeActivity.class));
                    finish();
                }
            }, 3000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getBaseContext(), LoginActivity.class));
                    finish();
                }
            }, 3000);
        }

    }
}
