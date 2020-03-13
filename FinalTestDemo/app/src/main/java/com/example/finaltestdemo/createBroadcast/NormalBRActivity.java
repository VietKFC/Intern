package com.example.finaltestdemo.createBroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.finaltestdemo.R;

public class NormalBRActivity extends AppCompatActivity {
    Switch apSwitch , chargeSwitch , cameraSwitch;
    private ReceiveBroadcast broadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_b_r);
        apSwitch = findViewById(R.id.airplane_switch);
        chargeSwitch = findViewById(R.id.charge_switch);
        cameraSwitch = findViewById(R.id.camera_switch);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcast);
    }
}
