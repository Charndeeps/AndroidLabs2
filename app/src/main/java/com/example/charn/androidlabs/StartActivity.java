package com.example.charn.androidlabs;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends Activity {

    protected static final String ACTIVITY_NAME = "Start Activity";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME,"In onCreate()");
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent = new Intent (StartActivity.this,ListItemActivity.class);
                startActivityForResult(intent,5);
            }

        });
        Button button1 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent = new Intent (StartActivity.this,ChatWindow.class);
                startActivityForResult(intent,5);
            }

        });

    }

    @Override

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onResume()");

    }

    @Override

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"In onStart()");

    }

    @Override

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"In onPause()");

    }
    @Override

    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onStop()");
    }

    @Override

    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");
    }

    protected void onActivityResult(int requestCode,int responseCode,Intent data){
        Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult -outside if");
        if(requestCode==5 && responseCode == RESULT_OK) {

            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult -in request code ==  5");
            String messagePassed = data.getStringExtra("Response");
            Toast.makeText(StartActivity.this, messagePassed,Toast.LENGTH_LONG).show();
            

        }


    }

}