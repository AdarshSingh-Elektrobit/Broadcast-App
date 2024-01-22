package com.example.broadcas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button broad;
    public final String package_name = "com.example.broadcas";
    BroadcastReceiver receiver = new reciever();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broad=findViewById(R.id.broad);
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.ADARSH_BROADCAST");
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        getApplicationContext().registerReceiver(receiver, filter , Context.RECEIVER_EXPORTED);
        broad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("key",package_name);
//                i.setPackage("com.example.broadcas");
                i.setAction("com.example.ADARSH_BROADCAST");
                sendOrderedBroadcast(i, null);
                sendBroadcast(i);
            }
        });
    }

}