package com.example.finaltestdemo.createBroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.finaltestdemo.R;

public class ReceiveSentBroadcast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_sent_broadcast);
    }

    public static class ReceiveCustomBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                String s = intent.getStringExtra("name");
                Toast.makeText(context, "Received Broadcast", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
