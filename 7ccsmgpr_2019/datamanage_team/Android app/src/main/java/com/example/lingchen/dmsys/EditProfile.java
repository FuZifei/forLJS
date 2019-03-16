package com.example.lingchen.dmsys.MyAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lingchen.dmsys.LoginSignup.Login;
import com.example.lingchen.dmsys.MainActivity;
import com.example.lingchen.dmsys.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class EditProfile extends AppCompatActivity {

    EditText EditPassword,EditEmail;
    Button EditConfirm;
    // ProgressBar loading;
    String ee,ep;
    RequestParams params;
    AsyncHttpClient client;
    String URL_LOGIN = "http://10.40.133.195:8080/Android_dmsys/MyAccount/EditProfile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        EditEmail = (EditText) findViewById(R.id.EditEmailEt);
        EditPassword = (EditText) findViewById(R.id.LogPasswordEt);
        EditConfirm = (Button) findViewById(R.id.EditConfirmBtn);

        EditConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ee = EditEmail.getText().toString();
                ep = EditPassword.getText().toString();


                params = new RequestParams();
                params.put("k7", ee);
                params.put("k8", ep);

                client = new AsyncHttpClient();
                client.post(URL_LOGIN,params,new JsonHttpResponseHandler(){

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Toast.makeText(EditProfile.this,"Edit Success!" + response,Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(EditProfile.this, MainActivity.class);
                        startActivity(intent);


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                        Toast.makeText(EditProfile.this, "Something Went Wrong...", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}

