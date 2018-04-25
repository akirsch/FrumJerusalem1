package com.example.android.frumjerusalem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {

    RecyclerView recyclerView;
    AttractionsAdapter attractionsAdapter;


    public ParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attraction_list, container, false);

        ArrayList<Attraction> parkAttractions = new ArrayList<>();

        parkAttractions.add(new Attraction(getResources().getString(R.string.teddy_park_name)
                , getResources().getString(R.string.teddy_park_times)
                , getResources().getString(R.string.teddy_park_summary)
                , getResources().getString(R.string.teddy_park_description)
                , getResources().getString(R.string.teddy_park_address)
                , getResources().getString(R.string.teddy_park_url),
                5, R.drawable.teddy_park));
        parkAttractions.add(new Attraction(getResources().getString(R.string.bell_park_name)
                , getResources().getString(R.string.bell_park_times)
                , getResources().getString(R.string.bell_park_summary)
                , getResources().getString(R.string.bell_park_description)
                , getResources().getString(R.string.bell_park_address)
                , getResources().getString(R.string.bell_park_url),
                3, R.drawable.bell_park));
        parkAttractions.add(new Attraction(getResources().getString(R.string.gan_sachar_name)
                , getResources().getString(R.string.gan_sachar_times)
                , getResources().getString(R.string.gan_sachar_summary)
                , getResources().getString(R.string.gan_sachar_description)
                , getResources().getString(R.string.gan_sachar_address)
                , getResources().getString(R.string.gan_sachar_url),
                4, R.drawable.gan_sachar));
        parkAttractions.add(new Attraction(getResources().getString(R.string.bot_gardens_name)
                , getResources().getString(R.string.bot_gardens_times)
                , getResources().getString(R.string.bot_gardens_summary)
                , getResources().getString(R.string.bot_gardens_description)
                , getResources().getString(R.string.bot_gardens_phone_number)
                , getResources().getString(R.string.bot_gardens_address)
                , getResources().getString(R.string.bot_gardens_url),
                3, R.drawable.botanical_gardens));
        parkAttractions.add(new Attraction(getResources().getString(R.string.rose_garden_name)
                , getResources().getString(R.string.rode_garden_times)
                , getResources().getString(R.string.rose_garden_summary)
                , getResources().getString(R.string.rose_garden_description)
                , getResources().getString(R.string.rose_garden_address)
                , getResources().getString(R.string.rose_garden_url),
                5, R.drawable.rose_garden));


        // Find the RecyclerViw in the layout file
        recyclerView = rootView.findViewById(R.id.attractionsRecyclerView);
        // Create adapter passing in ArrayList as the data source
        attractionsAdapter = new AttractionsAdapter(parkAttractions);
        // Attach the adapter to the RecyclerView to populate items
        recyclerView.setAdapter(attractionsAdapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }


}
