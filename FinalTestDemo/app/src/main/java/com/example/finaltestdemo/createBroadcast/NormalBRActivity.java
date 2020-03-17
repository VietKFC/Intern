package com.example.finaltestdemo.createBroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.finaltestdemo.R;

public class NormalBRActivity extends AppCompatActivity {
    Switch apSwitch , chargeSwitch , cameraSwitch;
    private ReceiveBroadcast broadcast;
    Button sendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_b_r);
        apSwitch = findViewById(R.id.airplane_switch);
        chargeSwitch = findViewById(R.id.charge_switch);
        cameraSwitch = findViewById(R.id.camera_switch);
        sendBtn = findViewById(R.id.sendBtn);
        broadcast = new ReceiveBroadcast();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_BOOT_COMPLETED");
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
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
                //LocalBroadcastManager.getInstance(getApplicationContext()).
                IntentFilter intentFilters = new IntentFilter();
                intentFilters.addAction("com.example.finaltestdemo.createBroadcast");
                registerReceiver(new ReceiveSentBroadcast.ReceiveCustomBroadcast(), intentFilters);
                Intent intent = new Intent();
                intent.setAction("com.example.finaltestdemo.createBroadcast");
                sendBroadcast(intent);
            }
        });
    }
    public void disableReceiver(Context context , Class c){
        ComponentName componentName = new ComponentName(context , c);
        PackageManager packageManager =context.getPackageManager();
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
