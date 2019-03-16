package com.example.lingchen.dmsys.LoginSignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.StrictMode;

import java.lang.Throwable;
import java.lang.String;

import com.example.lingchen.dmsys.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Signup extends AppCompatActivity {

    EditText FullName, SignEmail, SignPassword;
    Button SignUp;
    String fn, se, sp;
    RequestParams params;
    AsyncHttpClient client;
    String URL_SIGNUP = "http://10.217.135.195:8080/Android_dmsys/Login_Signup/Register";
    //private static final String LOG_TAG = "JsonHttpRH";
    //private boolean useRFC5179CompatibilityMode = true;
    //static String jsonString = "";
    //static JSONObject jObj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        FullName = findViewById(R.id.FullNameEt);
        SignEmail = findViewById(R.id.SignEmailEt);
        SignPassword = findViewById(R.id.SignPasswordEt);
        SignUp = findViewById(R.id.SignUpBtn);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn = FullName.getText().toString();
                se = SignEmail.getText().toString();
                sp = SignPassword.getText().toString();

                params = new RequestParams();
                params.put("k1", fn);
                params.put("k2", se);
                params.put("k3", sp);

                client = new AsyncHttpClient();
                client.post(URL_SIGNUP, params, new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Toast.makeText(Signup.this, "Register Success!" + response, Toast.LENGTH_LONG).show();

                        Intent sign_up_success = new Intent(Signup.this,Login.class);
                        startActivity(sign_up_success);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                        Toast.makeText(Signup.this, "Something Went Wrong...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
