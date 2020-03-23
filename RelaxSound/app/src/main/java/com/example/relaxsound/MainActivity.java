package com.example.relaxsound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.relaxsound.fragment.RainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RainFragment rainFragment;
    FragmentManager fragmentManager;
    ImageView waterImg , treeImg;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waterImg = findViewById(R.id.water_icon);
        treeImg = findViewById(R.id.natural);
        waterImg.setOnClickListener(this);
        treeImg.setOnClickListener(this);
        rainFragment = new RainFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_frame , rainFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.water_icon:
//                fragmentTransaction.add(R.id.container_frame , rainFragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                break;
            case R.id.natural:

                break;
        }
    }
}
