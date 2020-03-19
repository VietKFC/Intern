package com.example.relaxsound.adapter;

import android.content.Context;
import android.media.TimedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.relaxsound.R;
import com.example.relaxsound.model.RainIcon;

import java.util.ArrayList;

public class RainAdapter extends RecyclerView.Adapter<RainAdapter.ViewHolder> {
    ArrayList<RainIcon> rainIcons;
    Context context;

    public RainAdapter(ArrayList<RainIcon> rainIcons, Context context) {
        this.rainIcons = rainIcons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.rain_row , parent , false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RainIcon rainIcon = rainIcons.get(position);
        if(rainIcon != null) {
            holder.imageView.setImageResource(rainIcon.getId());
        }
    }

    @Override
    public int getItemCount() {
        return rainIcons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_row);
        }
    }
}
