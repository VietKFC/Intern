package com.example.finaltestdemo.orderedBroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

public class ReceiveOrderedBroadcast1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
           Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
    }
}
