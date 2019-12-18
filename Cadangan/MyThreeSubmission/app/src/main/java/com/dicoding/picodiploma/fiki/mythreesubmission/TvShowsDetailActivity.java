package com.dicoding.picodiploma.fiki.mythreesubmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.picodiploma.fiki.mythreesubmission.model.TVShows;
import com.squareup.picasso.Picasso;

public class TvShowsDetailActivity extends AppCompatActivity {

    TVShows tvShow;
    TextView tvTitle, tvDesc, tvTahun, tvTahunTrans, tvDescTrans;
    ImageView ivMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows_detail);
    }

    private void initView() {

        tvTahunTrans = findViewById(R.id.textViewtahun_tvshow);
        tvDescTrans = findViewById(R.id.textViewDesc_tvshow);

        //penerima intent
        tvTitle = findViewById(R.id.tv_title_tvshow);
        tvDesc = findViewById(R.id.tv_desc_tvshow);
        ivMovie = findViewById(R.id.imageView_tvshow);
        tvTahun = findViewById(R.id.tv_tahun_tvshow);

        TVShows tvShow = getIntent().getExtras().getParcelable("EXTRAS");

        String title = tvShow.getTitleTVShow();
        String description = tvShow.getDescriptionTVShow();
        String yearTv = tvShow.getTahunTVShow();
        String img = tvShow.getImageTVShow();

        tvTitle.setText(title);
        tvDesc.setText(description);
        tvTahun.setText(yearTv);
        Picasso.get().load(img).into(ivMovie);
        getSupportActionBar().setTitle(title);
    }
}
