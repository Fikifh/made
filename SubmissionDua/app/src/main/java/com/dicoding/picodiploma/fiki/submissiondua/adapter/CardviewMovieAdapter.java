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
import com.dicoding.picodiploma.fiki.submissiondua.activity.DetailMovieActivity;
import com.dicoding.picodiploma.fiki.submissiondua.model.Movie;
import com.dicoding.picodiploma.fiki.submissiondua.R;

import java.util.ArrayList;

public class CardviewMovieAdapter extends RecyclerView.Adapter<CardviewMovieAdapter.CardViewViewHolder> {
    private ArrayList<Movie> listMovie;
    Context context;
    Activity activity;
    OnItemClickListener mOnItemClickListener;

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public boolean get(int position) {
        return true;
    }

    public CardviewMovieAdapter(ArrayList<Movie> listMovie, Context context, Activity activity, OnItemClickListener mOnItemClickListener) {
        this.listMovie = listMovie;
        this.context = context;
        this.activity = activity;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public CardviewMovieAdapter(ArrayList<Movie> listMovie, Context context) {
        this.listMovie = listMovie;
        this.context = context;
    }

    @NonNull
    @Override
    public CardviewMovieAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_, viewGroup,false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardviewMovieAdapter.CardViewViewHolder cardViewViewHolder, final int position) {
        final Movie movie = listMovie.get(position);
        Glide.with(cardViewViewHolder.itemView.getContext())
                .load(movie.getImageMovie())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvTitle.setText(movie.getTitleMovie());
        cardViewViewHolder.tvDesc.setText(movie.getDescription());
        cardViewViewHolder.tvTahun.setText(movie.getTahun());

        cardViewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailMovieActivity.class));
                Intent i = new Intent(context, DetailMovieActivity.class);
                i.putExtra("EXTRAS", movie);
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvDesc, tvTahun;
        Button btnDetail;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
                imgPhoto = itemView.findViewById(R.id.img_item_photo);
                tvTitle = itemView.findViewById(R.id.tv_title);
                tvDesc = itemView.findViewById(R.id.tv_desc);
                tvTahun = itemView.findViewById(R.id.tv_year);
                //btnDetail = itemView.findViewById(R.id.btn_detail);
        }

        public boolean getItem(int position) {
            return true;
        }
    }
}
