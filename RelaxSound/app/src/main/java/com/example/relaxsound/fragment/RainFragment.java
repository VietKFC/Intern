package com.example.relaxsound.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    }


}
