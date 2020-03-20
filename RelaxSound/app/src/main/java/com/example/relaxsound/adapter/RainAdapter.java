package com.example.relaxsound.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.relaxsound.R;
import com.example.relaxsound.model.RainIcon;

import java.util.ArrayList;

public class RainAdapter extends RecyclerView.Adapter<RainAdapter.ViewHolder> {
    ArrayList<RainIcon> rainIcons;
    Context context;
    private MediaPlayer mediaPlayer = null;
    private AudioManager audioManager = null;
    private SeekBar seekBar = null;
    private static boolean click = false;
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
    private int index = -1;
    public void setIndex(int index){
        this.index = index;
        notifyDataSetChanged();
    }
    public int getIndex(){
        return index;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final RainIcon rainIcon = rainIcons.get(position);
        if(rainIcon != null) {
            holder.imageView.setImageResource(rainIcon.getId());
//            if(getIndex() == position){
//                if(mediaPlayer != null) {
//                    click = true;
//                    mediaPlayer.start();
//                }
//            }else{
//                click = false;
//                mediaPlayer.stop();
//                mediaPlayer = null;
//            }
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mediaPlayer == null){
                        mediaPlayer = MediaPlayer.create(context, rainIcon.getMp3Uri());
                    }
//                    if(getIndex() == -1){
//                        setIndex(position);
//                    }else{
//                        if(getIndex() == position){
//                            setIndex(-1);
//                        }else{
//                            setIndex(position);
//                        }
//                    }
                    if(holder.seekBar.getVisibility() == View.VISIBLE){
                        holder.seekBar.setVisibility(View.INVISIBLE);
                    }
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        holder.seekBar.setVisibility(View.INVISIBLE);
                        mediaPlayer = null;
                    }
                    if(mediaPlayer !=null) {
                        mediaPlayer.start();
                        holder.seekBar.setVisibility(View.VISIBLE);
                        initVolume();
                    }
                }
            });
        }
    }
    private void initVolume(){
        try{
            audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC , progress , 0);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return rainIcons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        SeekBar seekBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_row);
            seekBar = itemView.findViewById(R.id.seekBar_volume);
        }
    }
}
