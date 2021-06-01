package com.example.communitywatermis;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("MainActivity.onCreate: " + FirebaseInstanceId.getInstance().getToken());
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent secondIntent=new Intent(MainActivity.this,Login.class);
                startActivity(secondIntent);
                finish();
            }

        },SPLASH_TIME_OUT);
    }
}