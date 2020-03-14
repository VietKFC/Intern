package com.example.finaltestdemo.orderedBroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceiveOrderedBroadcast2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            Log.e("abc" , "gdsagsdgsgfgdhdfhdfgdfgdsfgsgsg");
            Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
    }
}
