package com.example.lingchen.dmsys.LoginSignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lingchen.dmsys.R;

public class LoginSignup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        Button main_login_button = (Button)findViewById(R.id.mainLogInBtn);
        main_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_intent = new Intent(LoginSignup.this,Login.class);
                startActivity(login_intent);
            }
        });
        Button main_signup_button = (Button)findViewById(R.id.mainSignUpBtn);
        main_signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup_intent = new Intent(LoginSignup.this,Signup.class);
                startActivity(signup_intent);
            }
        });
        //Intent LoginSignup = new Intent(LoginSignup.this,MainActivity.class);
        //startActivity(LoginSignup);
    }
}
