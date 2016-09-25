package com.example.anurag.sunshine;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by anurag on 31/7/16.
 */
public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_detail);
        if (SavedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.detail_container, new DetailFragment()).commit();
        }

    }
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.detail,menu);
//        return true;
//    }
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings){
//            startActivity(new Intent(this, SettingsActivity.class));
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public static class DetailFragment extends Fragment {

        private static final String LOG_TAG = DetailFragment.class.getSimpleName();
        private static final String hashtagAppName = "#SunshineApp";
        private String mForecastStr;
        public DetailFragment(){
            setHasOptionsMenu(true);
        }
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_detail,container,false);
            Intent intent = getActivity().getIntent();
            TextView textView = (TextView) rootView.findViewById(R.id.detail_text);
            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
                mForecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
                textView.setText(mForecastStr);
            }
            return rootView;
        }

        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
            inflater.inflate(R.menu.detailfragment,menu);
            MenuItem item = menu.findItem(R.id.action_share);
            ShareActionProvider mShareActionProvider = (ShareActionProvider)MenuItemCompat.getActionProvider(item);
            if (mShareActionProvider != null) {
                mShareActionProvider.setShareIntent(createShareIntent());
            }else {
                Log.d(LOG_TAG,"mShareActionProvider is null");
            }
        }

        public Intent createShareIntent(){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,mForecastStr + hashtagAppName);
            return intent;
        }

    }
}


