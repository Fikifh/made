package com.dicoding.picodiploma.fiki.submissiondua.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.picodiploma.fiki.submissiondua.model.Movie;
import com.dicoding.picodiploma.fiki.submissiondua.R;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {
    Movie movie;
    TextView tvTitle, tvDesc, tvTahun, tvTahunTrans, tvDescTrans;
    ImageView ivMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        initView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DetailMovieActivity.this, MainActivity.class);
        startActivity(intent);
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

    private void initView() {
        tvTahunTrans = findViewById(R.id.textViewtahun_tvshow);
        tvDescTrans = findViewById(R.id.textViewDesc_tvshow);

        tvTahunTrans.setText(getResources().getString(R.string.tahun));
        tvDescTrans.setText(getResources().getString(R.string.deskripsi));

        //penerima intent
        tvTitle = findViewById(R.id.tv_title_movies);
        tvDesc = findViewById(R.id.tv_desc_movies);
        ivMovie = findViewById(R.id.imageView_movies);
        tvTahun = findViewById(R.id.tv_tahun);
        movie = getIntent().getExtras().getParcelable("EXTRAS");

        String title = movie.getTitleMovie();
        String description = movie.getDescription();
        String tahun = movie.getTahun();
        int img = movie.getImageMovie();

        tvTitle.setText(title);
        tvDesc.setText(description);
        tvTahun.setText(tahun);
        Picasso.get().load(img).into(ivMovie);
        getSupportActionBar().setTitle(title);
    }

}
