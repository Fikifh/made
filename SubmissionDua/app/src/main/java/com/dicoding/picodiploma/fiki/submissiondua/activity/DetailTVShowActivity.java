package com.dicoding.picodiploma.fiki.submissiondua.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.picodiploma.fiki.submissiondua.R;
import com.dicoding.picodiploma.fiki.submissiondua.fragment.TvShowFragment;
import com.dicoding.picodiploma.fiki.submissiondua.model.TvShow;
import com.squareup.picasso.Picasso;

public class DetailTVShowActivity extends AppCompatActivity {
    TvShow tvShow;
    TextView tvTitle, tvDesc, tvTahun, tvTahunTrans, tvDescTrans;
    ImageView ivMovie;
    TvShowFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshow);
        initView();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initView();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        initView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DetailTVShowActivity.this, MainActivity.class);
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
        tvTitle = findViewById(R.id.tv_title_tvshow);
        tvDesc = findViewById(R.id.tv_desc_tvshow);
        ivMovie = findViewById(R.id.imageView_tvshow);
        tvTahun = findViewById(R.id.tv_tahun_tvshow);

        TvShow tvShow = getIntent().getExtras().getParcelable("EXTRAS");

        String title = tvShow.getTitleTv();
        String description = tvShow.getDescription();
        String yearTv = tvShow.getYearTv();
        int img = tvShow.getImageTv();

        tvTitle.setText(title);
        tvDesc.setText(description);
        tvTahun.setText(yearTv);
        Picasso.get().load(img).into(ivMovie);
        getSupportActionBar().setTitle(title);
    }
}
