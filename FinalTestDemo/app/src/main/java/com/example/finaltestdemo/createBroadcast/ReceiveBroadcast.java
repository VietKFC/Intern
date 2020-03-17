package com.example.finaltestdemo.createBroadcast;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class ReceiveBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
        if(action != null){
            if(action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
                if(isAirplaneOn(context) == true){
                    Toast.makeText(context, "Airplane mode is on", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Airplane mode is off", Toast.LENGTH_SHORT).show();
                }
            }else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
                Toast.makeText(context, "Charge disconnected", Toast.LENGTH_SHORT).show();
            }else if(action.equals(Intent.ACTION_POWER_CONNECTED)){
                Toast.makeText(context, "Charge connected", Toast.LENGTH_SHORT).show();
            }else if(action.equals("android.provider.Telephony.SMS_RECEIVED")) {
                Bundle bundle = intent.getExtras();
                Object[] datas = (Object[]) bundle.get("pdus");
                String body = "";
                for (int i = 0; i < datas.length; i++) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) datas[i]);
                    body += smsMessage.getMessageBody();
                }
                String phone = SmsMessage.createFromPdu((byte[]) datas[0]).getOriginatingAddress();
                long time = SmsMessage.createFromPdu((byte[]) datas[0]).getTimestampMillis();
                Toast.makeText(context, phone + "\n" + convertLongtoTime(time), Toast.LENGTH_SHORT).show();
            }
        }
    }
    public String convertLongtoTime(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        return simpleDateFormat.format(time);
    }
    public static boolean isAirplaneOn(Context context){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1){
            return Settings.System.getInt(context.getContentResolver() ,
                    Settings.System.AIRPLANE_MODE_ON , 0) != 0;
        }else {
            return Settings.Global.getInt(context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
        }
    }
}
