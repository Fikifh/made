package com.dicoding.picodiploma.fiki.submissiondua.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.dicoding.picodiploma.fiki.submissiondua.model.Movie;
import com.dicoding.picodiploma.fiki.submissiondua.R;
import com.dicoding.picodiploma.fiki.submissiondua.activity.DetailMovieActivity;
import com.dicoding.picodiploma.fiki.submissiondua.adapter.CardviewMovieAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment implements View.OnClickListener{
    private RecyclerView rvMovie;
    private String[] dataMovieTitle;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private String[] dataTahun;
    private ArrayList<Movie> movies;
    private CardviewMovieAdapter adapter;

    View view;
    final static String KEY = "KEY";
    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_movies, container, false);
        //adapter = new CardviewMovieAdapter(movies,getContext());
        rvMovie = view.findViewById(R.id.rv_movies);
//        prepare();
//        addItem();


        AndroidNetworking.initialize(getActivity());
        readData();
//        showRecyclerCardView();
//        adapter = new CardviewMovieAdapter(movies, getContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void showRecyclerCardView(){
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardviewMovieAdapter adapter = new CardviewMovieAdapter(movies,getActivity());
        rvMovie.setAdapter(adapter);
    }
    private void prepare() {
        dataMovieTitle = getResources().getStringArray(R.array.data_movie_name);
        dataTahun = getResources().getStringArray(R.array.tahun_movie);
        dataDescription = getResources().getStringArray(R.array.data_desc_movie);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_movie);
    }
    private void addItem(){
        movies = new ArrayList<>();
        for (int i=0; i < dataMovieTitle.length; i++){
            Movie movie = new Movie();
            movie.setImageMovie(dataPhoto.getResourceId(i, -1));
            movie.setTitleMovie(dataMovieTitle[i]);
            movie.setTahun(dataTahun[i]);
            movie.setDescription(String.format(dataDescription[i]));
            movies.add(movie);
        }
    }

    private void readData(){
        AndroidNetworking.get("https://api.themoviedb.org/3/discover/movie?api_key=67b5496e1b4c26ad30c16ad08f2deaa2&language=en-US")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "onResponse: " +response);
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject data = response.getJSONObject(i);
                                movies.add(new Movie(
                                        data.getString("results")
//                                        data.getString("poster_path"),
//                                        data.getString("title"),
//                                        data.getString("overview"),
//                                        data.getString("release_date")
                                ));
                            }
                            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
                            adapter = new CardviewMovieAdapter(movies, getActivity());
                            rvMovie.setAdapter(adapter);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, "onError Tea: "+ anError);
                    }
                });
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.card_view){

        }
    }
}
