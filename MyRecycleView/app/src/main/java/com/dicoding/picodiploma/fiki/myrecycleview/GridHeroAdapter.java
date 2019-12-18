package com.dicoding.picodiploma.fiki.myrecycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {

    private ArrayList<Hero> listHero;

    public GridHeroAdapter(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }
    private ListHeroAdapter.OnItemClickCallback setOnItemClickCallback;
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_hero, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder gridViewHolder, int i) {
        Glide.with(gridViewHolder.itemView.getContext())
                .load(listHero.get(i).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgPhoto);

        gridViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnItemClickCallback.onItemClinked(listHero.get(gridViewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public void setOnItemClickCallback(ListHeroAdapter.OnItemClickCallback onItemClickCallback){
        this.setOnItemClickCallback = onItemClickCallback;
    }
    public interface OnItemClickCallback{
        void onItemClinked(Hero data);
    }
}
