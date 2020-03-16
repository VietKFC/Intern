package com.example.orderedbroadcast.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceiveBroadcast1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action != null){
            if(action.equals("com.example.orderedbroadcast")){
                Log.e("abc" , "got string 1");
                String s = intent.getStringExtra("name");
                Toast.makeText(context, s + "1", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
