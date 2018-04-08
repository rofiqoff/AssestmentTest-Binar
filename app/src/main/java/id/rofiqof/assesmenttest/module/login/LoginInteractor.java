package id.rofiqof.assesmenttest.module.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.rofiqof.assesmenttest.model.User;

public class LoginInteractor implements LoginInput {

    LoginOutput output;

    @Override
    public void loginInput(final String nama, final String password) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference tabelUser = database.getReference("User");

        tabelUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(nama).exists()) {
                    User user = dataSnapshot.child(nama).getValue(User.class);
                    if (user.getPassword().equals(password)) {
                        output.loginSuccess(user);
                    } else {
                        output.loginFailed("Login Failed");
                    }
                } else {
                    output.loginFailed("User not exist");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                output.loginFailed("Login Canceled");
            }
        });
    }
}
