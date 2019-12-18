package com.dicoding.picodiploma.fiki.submissiondua.fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.picodiploma.fiki.submissiondua.R;
import com.dicoding.picodiploma.fiki.submissiondua.model.TvShow;
import com.dicoding.picodiploma.fiki.submissiondua.adapter.TvShowAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment implements View.OnClickListener{
    private RecyclerView rvTvShow;
    private String[] dataTvShowTitle;
    private String[] dataDescription;
    private String[] dataTahun;
    private TypedArray dataPhoto;
    private ArrayList<TvShow> tvShows;
    View view;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        rvTvShow = view.findViewById(R.id.rv_tvshow);
        prepare();
        addItem();
        showRecyclerCardView();
        return view;
    }

    private void showRecyclerCardView(){
        rvTvShow.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvShowAdapter tvShowAdapter = new TvShowAdapter(tvShows, getActivity());
        rvTvShow.setAdapter(tvShowAdapter);
    }
    private void prepare() {
        dataTvShowTitle = getResources().getStringArray(R.array.data_tvshow_name);
        dataDescription = getResources().getStringArray(R.array.data_desc_tvshow);
        dataTahun = getResources().getStringArray(R.array.tahun_tvshow);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_tvshow);
    }
    private void addItem(){
        tvShows = new ArrayList<>();
        for (int i=0; i < dataTvShowTitle.length; i++){
            TvShow tvShow = new TvShow();
            tvShow.setImageTv(dataPhoto.getResourceId(i, -1));
            tvShow.setTitleTv(dataTvShowTitle[i]);
            tvShow.setYearTv(dataTahun[i]);
            tvShow.setDescription(dataDescription[i]);
            tvShows.add(tvShow);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
