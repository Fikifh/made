package com.dicoding.picodiploma.fiki.submissiondua.activity;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.dicoding.picodiploma.fiki.submissiondua.model.Movie;
import com.dicoding.picodiploma.fiki.submissiondua.fragment.MoviesFragment;
import com.dicoding.picodiploma.fiki.submissiondua.R;
import com.dicoding.picodiploma.fiki.submissiondua.fragment.TvShowFragment;
import com.dicoding.picodiploma.fiki.submissiondua.adapter.CardviewMovieAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private RecyclerView rvHeroes;
    private ArrayList<Movie> list = new ArrayList<>();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new MoviesFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.containterFragment, fragment, getClass().getSimpleName())
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new TvShowFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.containterFragment, fragment, getClass().getSimpleName())
                            .commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (savedInstanceState == null) {
            MoviesFragment fragment = new MoviesFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containterFragment, fragment, getClass().getSimpleName())
                    .commit();

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.bottom_nav);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        String title = getResources().getString(R.string.title);
        getSupportActionBar().setTitle(title);


        AndroidNetworking.initialize(getApplicationContext());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bahasa, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_change_settings){
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
