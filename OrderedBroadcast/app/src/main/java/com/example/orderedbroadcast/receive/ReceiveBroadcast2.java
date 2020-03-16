package com.example.orderedbroadcast.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceiveBroadcast2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("abc" , "got string 2");
        String s = intent.getStringExtra("name");
        Toast.makeText(context, s + "2", Toast.LENGTH_SHORT).show();
    }
}
