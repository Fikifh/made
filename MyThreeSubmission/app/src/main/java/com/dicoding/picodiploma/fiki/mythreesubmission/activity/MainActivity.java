package com.dicoding.picodiploma.fiki.mythreesubmission.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.dicoding.picodiploma.fiki.mythreesubmission.fragment.MoviesFragment;
import com.dicoding.picodiploma.fiki.mythreesubmission.R;
import com.dicoding.picodiploma.fiki.mythreesubmission.fragment.TvShowFragment;
import com.dicoding.picodiploma.fiki.mythreesubmission.adapter.ViewPagerAdapter;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tablayout_id);
        ViewPager viewPager = findViewById(R.id.viewpager_id);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        String moviesTitle = getResources().getString(R.string.movies_title);
        String tvShowsTitle = getResources().getString(R.string.tv_show_title);
        if(savedInstanceState == null){
            if (checkInternet()){
                // ada koneksi internet
                //menambahkan fragment
                viewPagerAdapter.addFragment(new MoviesFragment(), moviesTitle);
                viewPagerAdapter.addFragment(new TvShowFragment(), tvShowsTitle);

                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

                //menambahkan icon pada tab layout
                Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_movie);
                Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_live_tv_black_24dp);

                //menghilangkan shadow dari actionbar
                ActionBar actionBar = getSupportActionBar();
                Objects.requireNonNull(actionBar).setElevation(0);

                //menambahkan title pada Action Bar
                actionBar.setTitle(getResources().getString(R.string.app_name));
            } else {
                alertDialogShow();
            }
        }else {
            //menambahkan fragment
            viewPagerAdapter.addFragment(new MoviesFragment(), moviesTitle);
            viewPagerAdapter.addFragment(new TvShowFragment(), tvShowsTitle);

            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);

            //menambahkan icon pada tab layout
            Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_movie);
            Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_live_tv_black_24dp);

            //menghilangkan shadow dari actionbar
            ActionBar actionBar = getSupportActionBar();
            Objects.requireNonNull(actionBar).setElevation(0);

            //menambahkan title pada Action Bar
            actionBar.setTitle(getResources().getString(R.string.app_name));
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.change_menu, menu);

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

    /**
     * cek koneksi internet
     */

    private boolean checkInternet(){
        boolean connectStatus;
        ConnectivityManager ConnectionManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        connectStatus = networkInfo != null && networkInfo.isConnected();
        return connectStatus;
    }

    private void alertDialogShow(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle(R.string.titleNoKoneksi);

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage(R.string.yConfirm)
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}
