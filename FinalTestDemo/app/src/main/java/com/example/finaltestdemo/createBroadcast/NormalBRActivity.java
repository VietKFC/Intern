package com.example.finaltestdemo.createBroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.finaltestdemo.R;
import com.example.finaltestdemo.orderedBroadcasts.ReceiveOrderedBroadcast1;
import com.example.finaltestdemo.orderedBroadcasts.ReceiveOrderedBroadcast2;

public class NormalBRActivity extends AppCompatActivity {
    Switch apSwitch , chargeSwitch , cameraSwitch;
    private ReceiveBroadcast broadcast;
    Button sendBtn , sendOrdBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_b_r);
        apSwitch = findViewById(R.id.airplane_switch);
        chargeSwitch = findViewById(R.id.charge_switch);
        cameraSwitch = findViewById(R.id.camera_switch);
        sendBtn = findViewById(R.id.sendBtn);
        sendOrdBtn = findViewById(R.id.sendOrdBtn);
        broadcast = new ReceiveBroadcast();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_BOOT_COMPLETED");
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        //intentFilter2.addDataScheme("file");
        apSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    registerReceiver(broadcast , intentFilter);
                }else{
                    unregisterReceiver(broadcast);
                }
            }
        });
        chargeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    registerReceiver(broadcast , intentFilter);
                }else{
                    unregisterReceiver(broadcast);
                }
            }
        });
        cameraSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    registerReceiver(broadcast , intentFilter);
                }else{
                    unregisterReceiver(broadcast);
                }
            }
        });
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilters = new IntentFilter();
                intentFilters.addAction("com.example.finaltestdemo.createBroadcast");
                registerReceiver(new ReceiveSentBroadcast.ReceiveCustomBroadcast(), intentFilters);
                Intent intent = new Intent();
                intent.setAction("com.example.finaltestdemo.createBroadcast");
                sendBroadcast(intent);
            }
        });
        sendOrdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*IntentFilter intentFilter1 = new IntentFilter();
                intentFilter1.addAction("com.example.finaltestdemo.orderedBroadcasts");
                registerReceiver(new ReceiveOrderedBroadcast1() , intentFilter1);
                registerReceiver(new ReceiveOrderedBroadcast2() , intentFilter1);*/
                Intent intent = new Intent();
                intent.setAction(" com.example.finaltestdemo.orderedBroadcasts");
                intent.setPackage("com.example.finaltestdemo.createBroadcast");
                sendBroadcast(intent);
            }
        });
    }
    public void disableReceiver(){
        ComponentName componentName = new ComponentName(this , ReceiveBroadcast.class);
        PackageManager packageManager = getApplicationContext().getPackageManager();
        packageManager.setComponentEnabledSetting(componentName ,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED ,
                PackageManager.DONT_KILL_APP);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcast);
    }
}
