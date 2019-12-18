package com.dicoding.picodiploma.fiki.mythreesubmission.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dicoding.picodiploma.fiki.mythreesubmission.R;
import com.dicoding.picodiploma.fiki.mythreesubmission.fragment.MoviesFragment;
import com.dicoding.picodiploma.fiki.mythreesubmission.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class MoviesDetailActivity extends AppCompatActivity {
    private static final String IMAGE_URL_BASE_PATH= "https://image.tmdb.org/t/p/w185/";
    private ProgressBar progressBar;
    Movies movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detail);
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
        progressBar = findViewById(R.id.progressbarDetailMovie);

        tvTahunTrans.setText(getResources().getString(R.string.yeartext));
        tvDescTrans.setText(getResources().getString(R.string.deskripsi_movie));

        //penerima intent
        TextView tvTitle = findViewById(R.id.tv_title_movies);
        TextView tvDesc = findViewById(R.id.tv_desc_movies);
        ImageView ivMovie = findViewById(R.id.imageView_movies);
        TextView tvTahun = findViewById(R.id.tv_tahun);
        while (movie==null){
            showLoading(true);
            movie= Objects.requireNonNull(getIntent().getExtras()).getParcelable("EXTRAS");
        }
        String title = Objects.requireNonNull(movie).getTitle();
        String description = movie.getOverview();
        String tahun = movie.getReleaseDate();
        String image_url = IMAGE_URL_BASE_PATH + movie.getPosterPath();

        tvTitle.setText(title);
        tvDesc.setText(description);
        tvTahun.setText(tahun);
        Picasso.get().load(image_url).into(ivMovie);
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }
    public void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

}
