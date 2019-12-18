package com.dicoding.picodiploma.fiki.mybuttomnavigation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    TextView tvHello, tvPlural, tvXliff;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvHello = view.findViewById(R.id.tv_hello);
                tvPlural = view.findViewById(R.id.tv_plural);
        tvXliff = view.findViewById(R.id.tv_xliff);

        // Inflate the layout for this fragment
        int pokeCount = 3;
        String hello = String.format(getResources().getString(R.string.hello_world), "Narenda Wicaksono", pokeCount, "Yoza Aprilio");
        tvHello.setText(hello);
        int songCount = 5;
        String pluralText = getResources().getQuantityString(R.plurals.numberOfSongsAvailable, songCount, songCount);
        tvPlural.setText(pluralText);
        tvXliff.setText(getResources().getString(R.string.app_homeurl));
        super.onViewCreated(view, savedInstanceState);
    }
}
