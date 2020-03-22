package com.example.relaxsound.fragment;

import android.media.MediaPlayer;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.relaxsound.R;
import com.example.relaxsound.adapter.RainAdapter;
import com.example.relaxsound.model.RainIcon;

import java.util.ArrayList;

public class RainFragment extends BaseFragment implements View.OnClickListener {
    RecyclerView recyclerView;
    RainAdapter rainAdapter;
    ArrayList<RainIcon> rainIcons;
    public static CardView cardView;
    public static ImageView pauseImg;
    public static boolean ispause = false;
    @Override
    protected int initFragment() {
        return R.layout.rain_fragment;
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.rain_rcv);
        cardView = view.findViewById(R.id.card_setting);
        pauseImg = view.findViewById(R.id.pause);
        pauseImg.setOnClickListener(this);
        rainIcons = new ArrayList<>();
        rainAdapter = new RainAdapter(rainIcons , getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        recyclerView.setAdapter(rainAdapter);
        initArrayList();

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
        }
    }
}
