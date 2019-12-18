package com.dicoding.picodiploma.fiki.mythreesubmission;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //menambahkan fragment
        String moviesTitle = getResources().getString(R.string.movies_title);
        String tvShowsTitle = getResources().getString(R.string.tv_show_title);
        viewPagerAdapter.addFragment(new MoviesFragment(), moviesTitle);
        viewPagerAdapter.addFragment(new TvShowFragment(), tvShowsTitle);

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //menambahkan icon pada tab layout
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_movie);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_live_tv_black_24dp);

        //menghilangkan shadow dari actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

        //menambahkan title pada Action Bar
        actionBar.setTitle(getResources().getString(R.string.app_name));

        AndroidNetworking.initialize(getApplicationContext());

    }
}
