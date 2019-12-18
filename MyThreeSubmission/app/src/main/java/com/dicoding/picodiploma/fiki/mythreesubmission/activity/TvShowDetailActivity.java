package com.dicoding.picodiploma.fiki.mythreesubmission.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.dicoding.picodiploma.fiki.mythreesubmission.R;
import com.dicoding.picodiploma.fiki.mythreesubmission.model.TvShows;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class TvShowDetailActivity extends AppCompatActivity {

    private static final String IMAGE_URL_BASE_PATH= "https://image.tmdb.org/t/p/w185/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);
        initView();
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


    private void initView() {
        TextView tvTahunTrans = findViewById(R.id.textViewtahun_tvshow);
        TextView tvDescTrans = findViewById(R.id.textViewDesc_tvshow);

        tvTahunTrans.setText(getResources().getString(R.string.yeartext));
        tvDescTrans.setText(getResources().getString(R.string.deskripsi_movie));

        //penerima intent
        TextView tvTitle = findViewById(R.id.tv_title_tvshow);
        TextView tvDesc = findViewById(R.id.tv_desc_tvshow);
        ImageView ivTvShow = findViewById(R.id.imageView_tvshow);
        TextView tvTahun = findViewById(R.id.tv_tahun_tvshow);
        TvShows tvShows = Objects.requireNonNull(getIntent().getExtras()).getParcelable("EXTRAS");

        String title = Objects.requireNonNull(tvShows).getName();
        String description = tvShows.getOverview();
        String tahun = tvShows.getFirstAirDate();
        String image_url = IMAGE_URL_BASE_PATH + tvShows.getPosterPath();

        tvTitle.setText(title);
        tvDesc.setText(description);
        tvTahun.setText(tahun);
        Picasso.get().load(image_url).into(ivTvShow);
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }
}

