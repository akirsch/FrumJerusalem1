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
public class IndoorsFragment extends Fragment {

    RecyclerView recyclerView;
    AttractionsAdapter attractionsAdapter;


    public IndoorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attraction_list, container, false);

        ArrayList<Attraction> inDoorAttractions = new ArrayList<>();

        inDoorAttractions.add(new Attraction(getResources().getString(R.string.israel_museum_name)
                , getResources().getString(R.string.israel_museum_times)
                , getResources().getString(R.string.israel_museum_summary)
                , getResources().getString(R.string.israel_museum_description)
                , getResources().getString(R.string.israel_museum_phone_number)
                , getResources().getString(R.string.israel_museum_address)
                , getResources().getString(R.string.israel_museum_url)
                , 4, R.drawable.israel_museum));
        inDoorAttractions.add(new Attraction(getResources().getString(R.string.tunnel_tours_name)
                , getResources().getString(R.string.tunnel_tours_times)
                , getResources().getString(R.string.tunnel_tours_summary)
                , getResources().getString(R.string.tunnel_tours_description)
                , getResources().getString(R.string.tunnel_tours_phone_number)
                , getResources().getString(R.string.tunnel_tours_address)
                , getResources().getString(R.string.tunnel_tours_url)
                , 5, R.drawable.kotel_tunnels));
        inDoorAttractions.add(new Attraction(getResources().getString(R.string.yad_vashem_name)
                , getResources().getString(R.string.yad_vashem_times)
                , getResources().getString(R.string.yemin_summary)
                , getResources().getString(R.string.yad_vashem_decription)
                , getResources().getString(R.string.yad_vashem_phone_number)
                , getResources().getString(R.string.yad_vashem_address)
                , getResources().getString(R.string.yad_vashem_url)
                , 4, R.drawable.yad_vashem));
        inDoorAttractions.add(new Attraction(getResources().getString(R.string.aquarium_name)
                , getResources().getString(R.string.aquarium_times)
                , getResources().getString(R.string.aquarium_summary)
                , getResources().getString(R.string.aquarium_description)
                , getResources().getString(R.string.aquarium_phone_number)
                , getResources().getString(R.string.aquarium_address)
                , getResources().getString(R.string.aquarium_url)
                , 5, R.drawable.aquarium));
        inDoorAttractions.add(new Attraction(getResources().getString(R.string.science_museum_name)
                , getResources().getString(R.string.science_museum_times)
                , getResources().getString(R.string.science_museum_summary)
                , getResources().getString(R.string.science_museum_description)
                , getResources().getString(R.string.science_museum_phone_number)
                , getResources().getString(R.string.science_museum_address)
                , getResources().getString(R.string.science_museum_url)
                , 4, R.drawable.science_museum));


        // Find the RecyclerViw in the layout file
        recyclerView = rootView.findViewById(R.id.attractionsRecyclerView);
        // Create adapter passing in ArrayList as the data source
        attractionsAdapter = new AttractionsAdapter(inDoorAttractions);
        // Attach the adapter to the RecyclerView to populate items
        recyclerView.setAdapter(attractionsAdapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }

}
