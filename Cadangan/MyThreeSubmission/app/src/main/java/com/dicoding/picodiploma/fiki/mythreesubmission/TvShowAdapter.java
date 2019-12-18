package com.dicoding.picodiploma.fiki.mythreesubmission;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.fiki.mythreesubmission.model.TVShows;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private ArrayList<TVShows> listTShows;
    Context context;
    Activity activity;

    public TvShowAdapter() {
    }

    public ArrayList<TVShows> getListTShows() {
        return listTShows;
    }

    public void setListTShows(ArrayList<TVShows> listTShows) {
        this.listTShows = listTShows;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder tvShowViewHolder, int i) {

        final TVShows tvShow = listTShows.get(i);
        Glide.with(tvShowViewHolder.itemView.getContext())
                .load(tvShow.getImageTVShow())
                .apply(new RequestOptions().override(350, 550))
                .into(tvShowViewHolder.imgPhoto);

        tvShowViewHolder.tvTitle.setText(tvShow.getTitleTVShow());
        tvShowViewHolder.tvDesc.setText(tvShow.getDescriptionTVShow());
        tvShowViewHolder.tvYears.setText(tvShow.getTahunTVShow());
        tvShowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                context.startActivity(new Intent(context, DetailTVShowActivity.class));
//                Intent i = new Intent(context, DetailTVShowActivity.class);
//                i.putExtra("EXTRAS", tvShow);
//                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTShows.size();
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvDesc, tvYears;

        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo_id);
            tvTitle = itemView.findViewById(R.id.tv_title_id);
            tvDesc = itemView.findViewById(R.id.tv_desc_id);
            tvYears = itemView.findViewById(R.id.tv_year_id);
        }
    }
}
