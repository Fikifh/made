package com.dicoding.picodiploma.fiki.submissiondua.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.fiki.submissiondua.R;
import com.dicoding.picodiploma.fiki.submissiondua.activity.DetailMovieActivity;
import com.dicoding.picodiploma.fiki.submissiondua.activity.DetailTVShowActivity;
import com.dicoding.picodiploma.fiki.submissiondua.model.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewViewHolder> {
    private ArrayList<TvShow> listTv;
    Context context;
    Activity activity;
    OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }
    public TvShowAdapter(ArrayList<TvShow> listTv, Context context) {
        this.listTv = listTv;
        this.context = context;
    }

    public boolean get(int position) {
        return true;
    }

    @NonNull
    @Override
    public ViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_, viewGroup,false);
        return new ViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewViewHolder viewViewHolder, int i) {
        final TvShow tvShow = listTv.get(i);
        Glide.with(viewViewHolder.itemView.getContext())
                .load(tvShow.getImageTv())
                .apply(new RequestOptions().override(350, 550))
                .into(viewViewHolder.imgPhoto);

        viewViewHolder.tvTitle.setText(tvShow.getTitleTv());
        viewViewHolder.tvDesc.setText(tvShow.getDescription());
        viewViewHolder.tvTahun.setText(tvShow.getYearTv());
        viewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailTVShowActivity.class));
                Intent i = new Intent(context, DetailTVShowActivity.class);
                i.putExtra("EXTRAS", tvShow);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    public ArrayList<TvShow> getListTv() {
        return listTv;
    }

    public void setListTv(ArrayList<TvShow> listTv) {
        this.listTv = listTv;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public class ViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvDesc, tvTahun;
        public ViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvTahun = itemView.findViewById(R.id.tv_year);
            tvDesc = itemView.findViewById(R.id.tv_desc);
        }

    }
}
