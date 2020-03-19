package com.example.relaxsound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.relaxsound.fragment.RainFragment;

public class MainActivity extends AppCompatActivity {
    RainFragment rainFragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rainFragment = new RainFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_frame , rainFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
