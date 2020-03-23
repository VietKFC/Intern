package com.example.relaxsound.fragment;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.format.Time;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.relaxsound.R;
import com.example.relaxsound.adapter.RainAdapter;
import com.example.relaxsound.model.RainIcon;
import com.example.relaxsound.receiver.TimeReceive;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RainFragment extends BaseFragment implements View.OnClickListener {
    RecyclerView recyclerView;
    RainAdapter rainAdapter;
    ArrayList<RainIcon> rainIcons;
    public static CardView cardView;
    public static ImageView pauseImg;
    public static ImageView clockImg;
    public static TimePicker timePicker;
    public static boolean ispause = false;
    public static long getHour , getMinute;
    public static final String DATA = "data" , TIME_KEY_HOUR = "hour", TIME_KEY_MINUTE = "minute";
    Dialog dialog;
    TextView doneTxt;
    long time1 = 0;
    TimeReceive timeReceive;
    @Override
    protected int initFragment() {
        return R.layout.rain_fragment;
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.rain_rcv);
        cardView = view.findViewById(R.id.card_setting);
        pauseImg = view.findViewById(R.id.pause);
        clockImg = view.findViewById(R.id.clock);
        timeReceive = new TimeReceive();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_TIME_TICK);
        getContext().registerReceiver(timeReceive , intentFilter);
        dialog = new Dialog(getContext());
        clockImg.setOnClickListener(this);
        pauseImg.setOnClickListener(this);
        rainIcons = new ArrayList<>();
        rainAdapter = new RainAdapter(rainIcons , getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        recyclerView.setAdapter(rainAdapter);
        initArrayList();

    }
    public static void putTime(Context context , String key , long time){
        createSharedPreference(context).edit().putLong(key , time).apply();
    }
    public static long getTime(Context context , String key){
        return createSharedPreference(context).getLong(key , 0);
    }
    public static final SharedPreferences createSharedPreference(Context context){
        return context.getSharedPreferences(DATA , Context.MODE_PRIVATE);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(timeReceive);
    }

    public long getCurrentTime(){
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.getTimeInMillis();
    }
    private void initArrayList() {
        rainIcons.add(new RainIcon(R.drawable.light_rain , R.raw.light_rain));
        rainIcons.add(new RainIcon(R.drawable.heavy_rain , R.raw.heavy_rain));
        rainIcons.add(new RainIcon(R.drawable.flash_rain , R.raw.thunder));
        rainIcons.add(new RainIcon(R.drawable.umbrella_rain , R.raw.rain_on_umbrella));
        rainIcons.add(new RainIcon(R.drawable.rain_on_roof , R.raw.rain_on_roof));
        rainIcons.add(new RainIcon(R.drawable.window_rain));
        rainIcons.add(new RainIcon(R.drawable.leaf_drop , R.raw.leaf_rain));
        rainIcons.add(new RainIcon(R.drawable.water_drop));
        rainIcons.add(new RainIcon(R.drawable.wave , R.raw.ocean_waves));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pause:
                if(!ispause){
                    pauseImg.setImageResource(R.drawable.ic_play);
                    RainAdapter.mediaPlayer.pause();
                    ispause = true;
                }else{
                    pauseImg.setImageResource(R.drawable.ic_pause);
                    RainAdapter.mediaPlayer.start();
                    ispause = false;
                }
                break;
            case R.id.clock:
                dialog.setContentView(R.layout.dialog_timepicker);
                timePicker = dialog.findViewById(R.id.timepicker_rain);
                doneTxt = dialog.findViewById(R.id.doneTxt);
                int hour , minute;
                String am_pm;
                doneTxt.setOnClickListener(this);
                dialog.getWindow().setBackgroundDrawable(null);
                dialog.show();
                break;
            case R.id.doneTxt:
                if(Build.VERSION.SDK_INT >= 23){
                    hour = timePicker.getHour();
                    minute = timePicker.getMinute();
                    getHour = hour;
                    getMinute = minute;
                }else {
                    hour = timePicker.getCurrentHour();
                    minute = timePicker.getCurrentMinute();
                    getHour = hour;
                    getMinute = minute;
                }
                if(hour > 12){
                    am_pm = "PM";
                    hour = hour -12;
                }else{
                    am_pm = "AM";
                }
                dialog.dismiss();
                break;
        }
    }
}
