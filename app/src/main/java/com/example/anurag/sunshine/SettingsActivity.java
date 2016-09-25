package com.example.anurag.sunshine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by anurag on 21/8/16.
 */
public class SettingsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().replace(R.id.content, new SettingsFragment()).commit();
        }
    }
}
