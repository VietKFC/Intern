package com.example.relaxsound.fragment;

import android.media.MediaPlayer;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.relaxsound.R;
import com.example.relaxsound.adapter.RainAdapter;
import com.example.relaxsound.model.RainIcon;

import java.util.ArrayList;

public class RainFragment extends BaseFragment {
    RecyclerView recyclerView;
    RainAdapter rainAdapter;
    ArrayList<RainIcon> rainIcons;
    @Override
    protected int initFragment() {
        return R.layout.rain_fragment;
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.rain_rcv);
        rainIcons = new ArrayList<>();
        rainAdapter = new RainAdapter(rainIcons , getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 3));
        recyclerView.setAdapter(rainAdapter);
        initArrayList();

    }

    private void initArrayList() {
        rainIcons.add(new RainIcon(R.drawable.light_rain , R.raw.light_rain));
        rainIcons.add(new RainIcon(R.drawable.heavy_rain , R.raw.heavy_rain));
        rainIcons.add(new RainIcon(R.drawable.flash_rain));
        rainIcons.add(new RainIcon(R.drawable.umbrella_rain));
        rainIcons.add(new RainIcon(R.drawable.rain_on_roof));
        rainIcons.add(new RainIcon(R.drawable.window_rain));
        rainIcons.add(new RainIcon(R.drawable.leaf_drop , R.raw.leaf_rain));
        rainIcons.add(new RainIcon(R.drawable.water_drop));
        rainIcons.add(new RainIcon(R.drawable.wave));
    }


}
