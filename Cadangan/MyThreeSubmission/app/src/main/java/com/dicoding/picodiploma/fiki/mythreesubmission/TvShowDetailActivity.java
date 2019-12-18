package com.dicoding.picodiploma.fiki.mythreesubmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.picodiploma.fiki.mythreesubmission.model.Movies;
import com.squareup.picasso.Picasso;

public class TvShowDetailActivity extends AppCompatActivity {

    Movies movie;
    TextView tvTitle, tvDesc, tvTahun, tvTahunTrans, tvDescTrans;
    ImageView ivMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);
    }

    private void initView() {
        tvTahunTrans = findViewById(R.id.textViewtahun_tvshow);
        tvDescTrans = findViewById(R.id.textViewDesc_tvshow);

        tvTahunTrans.setText(getResources().getString(R.string.tahun));
        tvDescTrans.setText(getResources().getString(R.string.deskripsi_movie));

        //penerima intent
        tvTitle = findViewById(R.id.tv_title_movies);
        tvDesc = findViewById(R.id.tv_desc_movies);
        ivMovie = findViewById(R.id.imageView_movies);
        tvTahun = findViewById(R.id.tv_tahun);
        movie = getIntent().getExtras().getParcelable("EXTRAS");

        String title = movie.getTitleMovie();
        String description = movie.getDescription();
        String tahun = movie.getTahun();
        String img = movie.getImageMovie();

        tvTitle.setText(title);
        tvDesc.setText(description);
        tvTahun.setText(tahun);
        Picasso.get().load(img).into(ivMovie);
        getSupportActionBar().setTitle(title);
    }
}

