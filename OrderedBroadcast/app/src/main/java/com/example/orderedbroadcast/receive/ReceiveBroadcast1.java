package com.example.orderedbroadcast.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceiveBroadcast1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("abc" , "1 ");
        Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
    }
}
