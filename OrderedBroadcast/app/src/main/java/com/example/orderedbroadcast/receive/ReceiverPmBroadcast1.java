package com.example.orderedbroadcast.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceiverPmBroadcast1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("abc" , "got string 1");
        String s = intent.getStringExtra("name");
        Toast.makeText(context, s + "4", Toast.LENGTH_SHORT).show();
    }
}
