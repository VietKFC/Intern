package com.example.orderedbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.orderedbroadcast.receive.ReceiveBroadcast1;
import com.example.orderedbroadcast.receive.ReceiveBroadcast2;
import com.example.orderedbroadcast.receive.ReceiveBroadcast3;

public class MainActivity extends AppCompatActivity {
    Button sendBtn , sendPmBtn;
    BroadcastReceiver broadcastReceiver3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver3 = new ReceiveBroadcast3();
        IntentFilter intentFilter = new IntentFilter("com.example.orderedbroadcast");
        intentFilter.setPriority(1);
        registerReceiver(broadcastReceiver3 , intentFilter);
        sendBtn = findViewById(R.id.sendOdBtn);
        sendPmBtn = findViewById(R.id.sendPmBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.orderedbroadcast");
                intent.putExtra("name" , "got string ");
                //intent.setPackage("com.example.orderedbroadcast");
                sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        Toast.makeText(context, "Done!", Toast.LENGTH_SHORT).show();
                    }
                } , null , RESULT_OK , null , null);
                //sendBroadcast(intent);
            }
        });
        sendPmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent("com.example.orderedbroadcast1");
                    intent.putExtra("name", "got string ");
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
        unregisterReceiver(broadcastReceiver3);
    }
}
