package com.example.charn.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "Login Activity";
    EditText edtLogin,edtPassword;
    TextView loginText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"In onCreate()");
        Button loginButton = (Button) findViewById(R.id.button2);
        edtLogin = (EditText) findViewById(R.id.editText);
        edtPassword = (EditText) findViewById(R.id.editText2);
        final SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        edtLogin.setText(sharedPreferences.getString("DefaultEmail", "email@domain.com"));
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("DefaultEmail", edtLogin.getText().toString());
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override

    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override

    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onResume()");
    }

    @Override

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onStop()");

    }

    @Override

    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");

    }

    @Override

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");

    }
}