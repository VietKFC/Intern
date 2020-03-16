package com.example.orderedbroadcast.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceiveBroadcast3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action != null){
            if(action.equals("com.example.orderedbroadcast")){
                String s = intent.getStringExtra("name");
                Toast.makeText(context, s + "3", Toast.LENGTH_SHORT).show();
            }else if (action.equals("android.intent.action.AIRPLANE_MODE")){
                Log.e("receive" , "Local broadcastreceive");
            }
        }
    }
}
