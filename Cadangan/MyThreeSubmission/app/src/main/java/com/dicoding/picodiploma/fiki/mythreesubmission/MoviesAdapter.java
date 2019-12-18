package com.dicoding.picodiploma.fiki.mythreesubmission;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.fiki.mythreesubmission.model.Movies;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<Movies> listMovies;
    Context context;
    Activity activity;

    public MoviesAdapter(List<Movies> movies, FragmentActivity activity) {

    }

    public List<Movies> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
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
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder viewHolder, int i) {
        final Movies movie = listMovies.get(i);
        Glide.with(viewHolder.itemView.getContext())
                .load(movie.getImageMovie())
                .apply(new RequestOptions().override(350, 550))
                .into(viewHolder.imgPhoto);

        viewHolder.tvTitle.setText(movie.getTitleMovie());
        viewHolder.tvDesc.setText(movie.getDescription());
        viewHolder.tvYears.setText(movie.getTahun());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                context.startActivity(new Intent(context, DetailMovieActivity.class));
//                Intent i = new Intent(context, DetailMovieActivity.class);
//                i.putExtra("EXTRAS", movie);
//                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvDesc, tvYears;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo_id);
            tvTitle = itemView.findViewById(R.id.tv_title_id);
            tvDesc = itemView.findViewById(R.id.tv_desc_id);
            tvYears = itemView.findViewById(R.id.tv_year_id);
        }

        public boolean getItem(int position){
            return true;
        }
    }
}
