package com.dicoding.picodiploma.fiki.mythreesubmission.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dicoding.picodiploma.fiki.mythreesubmission.R;
import com.dicoding.picodiploma.fiki.mythreesubmission.activity.MainActivity;
import com.dicoding.picodiploma.fiki.mythreesubmission.adapter.MoviesAdapter;
import com.dicoding.picodiploma.fiki.mythreesubmission.api.MovieAPIService;
import com.dicoding.picodiploma.fiki.mythreesubmission.model.MoviesResponse;
import com.dicoding.picodiploma.fiki.mythreesubmission.model.Movies;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesFragment extends Fragment {

    private RecyclerView rvMovie;
    private ArrayList<Movies> movies = new ArrayList<>();

    private ProgressBar progressBar;

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    // insert your themoviedb.org API KEY here
    private final static String API_KEY = "67b5496e1b4c26ad30c16ad08f2deaa2";
    private  final static String MOVIE_KEY = "SI_KEY";

    public MoviesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movies_fragment, container, false);
        progressBar = v.findViewById(R.id.progressBar);
        rvMovie = v.findViewById(R.id.rv_movies_id);
        rvMovie.setHasFixedSize(true);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState == null){
            connectingAndGetAPIData();
        }else{
            movies = savedInstanceState.getParcelableArrayList(MOVIE_KEY);
            GridLayoutManager mLayoutManager  = new GridLayoutManager(getActivity(),2);
            rvMovie.setLayoutManager(mLayoutManager);
            MoviesAdapter mAdapter = new MoviesAdapter(movies);
            rvMovie.setAdapter(mAdapter);
        }
    }

    public void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void connectingAndGetAPIData(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        MovieAPIService movieAPIService = retrofit.create(MovieAPIService.class);
        Call<MoviesResponse> call = movieAPIService.getListMovies(API_KEY);
        showLoading(true);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                try{
                showLoading(false);
                movies = Objects.requireNonNull(response.body()).getResults();
                GridLayoutManager mLayoutManager  = new GridLayoutManager(getActivity(),2);
                rvMovie.setLayoutManager(mLayoutManager);

//                    MoviesAdapter mAdapter = new MoviesAdapter(movies, R.layout.movies_item, getContext());
                MoviesAdapter mAdapter = new MoviesAdapter(movies);
                rvMovie.setAdapter(mAdapter);

                Log.d(TAG, "Number of movies received: " + movies.size());
                }catch (Exception e){
                    Toast.makeText(getContext(), R.string.alertServer,Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(MOVIE_KEY, movies);
        super.onSaveInstanceState(outState);
    }
}
