package com.example.cs_ch.secondapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        ConnectionRunnable aConnectionRunnable = new ConnectionRunnable();
        Thread connectionThread = new Thread(aConnectionRunnable);
        connectionThread.start();
    }
}
