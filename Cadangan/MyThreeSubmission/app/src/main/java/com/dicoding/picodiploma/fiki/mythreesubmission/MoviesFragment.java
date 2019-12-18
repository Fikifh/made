package com.dicoding.picodiploma.fiki.mythreesubmission;

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

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.dicoding.picodiploma.fiki.mythreesubmission.model.Movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class MoviesFragment extends Fragment {

    private RecyclerView rvMovie;
    private String[] dataMovieTitle;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private String[] dataTahun;
    private List<Movies> movies;
    private MoviesAdapter adapter;

    final static String KEY = "KEY";
    View v;

    public MoviesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.movies_fragment, container, false);
        rvMovie = v.findViewById(R.id.rv_movies_id);

        readData();
        return v;
    }


    private void showRecyclerCardView(){
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MoviesAdapter(movies, getActivity());
        rvMovie.setAdapter(adapter);
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
                                //adding the product to product list
                                movies.add(new Movies(
                                        data.getString("poster_path"),
                                        data.getString("title"),
                                        data.getString("overview"),
                                        data.getString("release_date")
                                ));
                            }
                            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
                            adapter = new MoviesAdapter(movies, getActivity());
                            rvMovie.setAdapter(adapter);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
