package com.example.orderedbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orderedbroadcast.receive.ReceiveBroadcast1;

public class MainActivity extends AppCompatActivity {
    Button sendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn = findViewById(R.id.sendBtn);
//        IntentFilter intentFilter = new IntentFilter("com.example.orderedbroadcast");
//        //IntentFilter intentFilter1 = new IntentFilter();
//        //intentFilter1.addAction("com.example.orderedbroadcast");
//        registerReceiver(new ReceiveBroadcast1() , intentFilter);
//        //registerReceiver(new ReceiveBroadcast2() , intentFilter1);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.orderedbroadcast");
                intent.setPackage("com.example.orderedbroadcast");
                //sendOrderedBroadcast(intent, null);
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new ReceiveBroadcast1());
    }
}
