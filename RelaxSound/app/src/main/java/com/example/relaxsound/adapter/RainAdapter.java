package com.example.relaxsound.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.relaxsound.R;
import com.example.relaxsound.fragment.RainFragment;
import com.example.relaxsound.model.RainIcon;
import com.example.relaxsound.receiver.TimeReceive;

import java.sql.Time;
import java.util.ArrayList;

public class RainAdapter extends RecyclerView.Adapter<RainAdapter.ViewHolder> {
    ArrayList<RainIcon> rainIcons;
    Context context;
    public static MediaPlayer mediaPlayer = null;
    private AudioManager audioManager = null;
    private SeekBar seekBar = null;
    public boolean click = false;
    public RainAdapter(ArrayList<RainIcon> rainIcons, Context context) {
        this.rainIcons = rainIcons;
        this.context = context;
    }

    public RainAdapter() {
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
            if(getIndex() == position){
                holder.seekBar.setVisibility(View.VISIBLE);
                initVolume();
            }else{
                holder.seekBar.setVisibility(View.INVISIBLE);
            }
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rainIcon.getMp3Uri() != 0) {
                        if (mediaPlayer == null) {
                            mediaPlayer = MediaPlayer.create(context, rainIcon.getMp3Uri());
                        }
                        if (getIndex() == -1) {
                            setIndex(position);
                        } else {
                            if (getIndex() == position) {
                                setIndex(-1);
                            } else {
                                setIndex(-1);

                            }
                        }
                        if (mediaPlayer.isPlaying() || mediaPlayer.getCurrentPosition() > 1) {
                            RainFragment.cardView.setVisibility(View.INVISIBLE);
                            mediaPlayer.stop();
                            mediaPlayer = null;
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                            RainFragment.cardView.setVisibility(View.VISIBLE);
                            RainFragment.pauseImg.setImageResource(R.drawable.ic_pause);
                            RainFragment.ispause = false;
                            initVolume();
                        }
                    }
                }
            });
        }
    }
    private void setVolumeOption(Context context , int volume){
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setSpeakerphoneOn(true);
        assert audioManager != null;
        audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
    }
    private void initVolume(){
        try{
            audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
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
        public SeekBar seekBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_row);
            seekBar = itemView.findViewById(R.id.seekBar_volume);
        }
    }
}
