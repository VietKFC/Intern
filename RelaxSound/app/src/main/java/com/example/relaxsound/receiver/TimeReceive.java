package com.example.relaxsound.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.relaxsound.R;
import com.example.relaxsound.adapter.RainAdapter;
import com.example.relaxsound.fragment.RainFragment;

import java.util.Calendar;
import java.util.Random;

public class TimeReceive extends BroadcastReceiver {
    public static long currentHour , currentMinute;
    @Override
    public void onReceive(Context context, Intent intent) {
        currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        currentMinute = Calendar.getInstance().get(Calendar.MINUTE);
        if(RainFragment.getHour == currentHour && RainFragment.getMinute == currentMinute && RainAdapter.mediaPlayer != null) {
            Log.e("abc", "correct");
            RainAdapter.mediaPlayer.pause();
            RainFragment.pauseImg.setImageResource(R.drawable.ic_play);
        }
    }
}
