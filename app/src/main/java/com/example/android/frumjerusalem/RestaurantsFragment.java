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
public class RestaurantsFragment extends Fragment {

    RecyclerView recyclerView;
    AttractionsAdapter attractionsAdapter;


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attraction_list, container, false);

        ArrayList<Attraction> foodAttractions = new ArrayList<>();

        foodAttractions.add(new Attraction(getResources().getString(R.string.entrecote_name)
                , getResources().getString(R.string.entrecote_times)
                , getResources().getString(R.string.entrecote_summary)
                , getResources().getString(R.string.entrecote_description)
                , getResources().getString(R.string.entrecote_phone_number)
                , getResources().getString(R.string.entrecote_address)
                , getResources().getString(R.string.entrecote_url)
                , 5, R.drawable.entrecote));
        foodAttractions.add(new Attraction(getResources().getString(R.string.sheyan_name)
                , getResources().getString(R.string.sheyan_times)
                , getResources().getString(R.string.sheyan_summary)
                , getResources().getString(R.string.sheyan_description)
                , getResources().getString(R.string.sheyan_phone_number)
                , getResources().getString(R.string.sheyan_address)
                , getResources().getString(R.string.sheyan_url)
                , 4, R.drawable.sheyan));
        foodAttractions.add(new Attraction(getResources().getString(R.string.skyline_name)
                , getResources().getString(R.string.skyline_times)
                , getResources().getString(R.string.skyline_summary)
                , getResources().getString(R.string.skyline_description)
                , getResources().getString(R.string.skyline_phone_number)
                , getResources().getString(R.string.skyline_address)
                , getResources().getString(R.string.skyline_url)
                , 5, R.drawable.skyline_restaurant));
        foodAttractions.add(new Attraction(getResources().getString(R.string.ricotta_name)
                , getResources().getString(R.string.ricotta_times)
                , getResources().getString(R.string.ricotta_summary)
                , getResources().getString(R.string.ricotta_description)
                , getResources().getString(R.string.ricotta_number)
                , getResources().getString(R.string.ricotta_address)
                , getResources().getString(R.string.ricotta_url)
                , 3, R.drawable.ricotta));
        foodAttractions.add(new Attraction(getResources().getString(R.string.waffle_name)
                , getResources().getString(R.string.waffle_times)
                , getResources().getString(R.string.waffle_summary)
                , getResources().getString(R.string.waffle_description)
                , getResources().getString(R.string.waffle_phone_number)
                , getResources().getString(R.string.waffle_address)
                , getResources().getString(R.string.waffle_url)
                , 4, R.drawable.waffles));
        foodAttractions.add(new Attraction(getResources().getString(R.string.katzefet_name)
                , getResources().getString(R.string.katzefet_times)
                , getResources().getString(R.string.katzefet_summary)
                , getResources().getString(R.string.katzefet_summary)
                , getResources().getString(R.string.katzefet_phone_number)
                , getResources().getString(R.string.katzefet_address)
                , getResources().getString(R.string.katzefet_url)
                , 4, R.drawable.ice_cream_shop));

        // Find the RecyclerViw in the layout file
        recyclerView = rootView.findViewById(R.id.attractionsRecyclerView);
        // Create adapter passing in ArrayList as the data source
        attractionsAdapter = new AttractionsAdapter(foodAttractions);
        // Attach the adapter to the RecyclerView to populate items
        recyclerView.setAdapter(attractionsAdapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }

}
