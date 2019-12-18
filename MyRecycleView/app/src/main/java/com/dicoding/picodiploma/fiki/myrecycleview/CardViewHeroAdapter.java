package com.dicoding.picodiploma.fiki.myrecycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder> {
    private ArrayList<Hero> listHero;

    public CardViewHeroAdapter(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_hero, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder cardViewHolder, int i) {
        final Hero hero = listHero.get(i);
        Glide.with(cardViewHolder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(cardViewHolder.imgPhoto);

        cardViewHolder.tvName.setText(hero.getName());
        cardViewHolder.tvFrom.setText(hero.getFrom());

        cardViewHolder.btnFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cardViewHolder.itemView.getContext(), "Favorite "+
                        listHero.get(cardViewHolder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        
        cardViewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cardViewHolder.itemView.getContext(), "Share "+
                        listHero.get(cardViewHolder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        cardViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cardViewHolder.itemView.getContext(), "Kamu Memilih "+hero.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgPhoto;
        public TextView tvFrom;
        public TextView tvName;
        public Button btnFavorit;
        public Button btnShare;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            tvName = itemView.findViewById(R.id.tv_item_name);
            btnFavorit = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
