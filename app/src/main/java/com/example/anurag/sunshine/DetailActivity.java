package com.example.anurag.sunshine;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anurag on 31/7/16.
 */
public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_detail);
        if (SavedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.detail_container, new PlaceholderFragment()).commit();
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.detail,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment(){

        }
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_detail,container,false);
            return rootView;
        }
    }
}


