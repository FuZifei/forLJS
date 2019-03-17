package com.example.lingchen.dmsys.LoginSignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lingchen.dmsys.MainActivity;
import com.example.lingchen.dmsys.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Login extends AppCompatActivity {

    EditText LogEmailEt, LogPasswordEt;
    Button LoginBtn;
    // ProgressBar loading;
    String le, lp;
    RequestParams params;
    AsyncHttpClient client;
    String URL_LOGIN = "http://10.217.135.195:8080/Android_dmsys/Login_Signup/Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LogEmailEt = (EditText) findViewById(R.id.LogEmailEt);
        LogPasswordEt = (EditText) findViewById(R.id.LogPasswordEt);
        LoginBtn = (Button) findViewById(R.id.LoginBtn);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                le = LogEmailEt.getText().toString();
                lp = LogPasswordEt.getText().toString();

                params = new RequestParams();
                params.put("k5", le);
                params.put("k6", lp);

                client = new AsyncHttpClient();
                client.post(URL_LOGIN,params,new JsonHttpResponseHandler(){

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Toast.makeText(Login.this,"Login Success!" + response,Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                        Toast.makeText(Login.this, "Something Went Wrong...", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
