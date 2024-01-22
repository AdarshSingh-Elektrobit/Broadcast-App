package com.example.broadcas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class reciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String a = intent.getAction();
        if(a.equals("com.example.ADARSH_BROADCAST")) {
            String package_name = intent.getStringExtra("key");
            Toast.makeText(context, "Custom message received in native App "+package_name, Toast.LENGTH_SHORT).show();
//            Intent intent1 = new Intent(MainActivity.class, MainActivity2.class);
//            intent1.setClassName(package_name,MainActivity2.class.getName());
//            context.startActivity(intent1);
        }
       else if (isAirplaneModeOn(context.getApplicationContext())) {
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "AirPlane mode is off", Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
    }
