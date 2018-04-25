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
public class OutdoorsFragment extends Fragment {

    RecyclerView recyclerView;
    AttractionsAdapter attractionsAdapter;


    public OutdoorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_attraction_list, container, false);

        ArrayList<Attraction> outDoorAttractions = new ArrayList<>();

        outDoorAttractions.add(new Attraction(getResources().getString(R.string.kotel_name)
                , getResources().getString(R.string.kotel_times)
                , getResources().getString(R.string.kotel_summary)
                , getResources().getString(R.string.kotel_description)
                , getResources().getString(R.string.kotel_phone_number)
                , getResources().getString(R.string.kotel_address)
                , getResources().getString(R.string.kotel_url)
                , 5, R.drawable.wailing_wall));
        outDoorAttractions.add(new Attraction(getResources().getString(R.string.machane_yehudah_name)
                , getResources().getString(R.string.machane_yehudah_times)
                , getResources().getString(R.string.machane_yehudah_summary)
                , getResources().getString(R.string.machane_yehudah_description)
                ,getResources().getString(R.string.machane_yehudah_address)
                , getResources().getString(R.string.machane_yehuah_url),
                4,R.drawable.machane_yehuda));
        outDoorAttractions.add(new Attraction(getResources().getString(R.string.zoo_name)
                , getResources().getString(R.string.zoo_times)
                , getResources().getString(R.string.zoo_summary)
                , getResources().getString(R.string.zoo_description)
                , getResources().getString(R.string.zoo_phone_number)
                , getResources().getString(R.string.zoo_address)
                , getResources().getString(R.string.zoo_address)
                , 3, R.drawable.zoo));
        outDoorAttractions.add(new Attraction(getResources().getString(R.string.yemin_name)
                , getResources().getString(R.string.yemin_times)
                , getResources().getString(R.string.yemin_summary)
                , getResources().getString(R.string.yemin_description)
                , getResources().getString(R.string.yemin_address)
                , getResources().getString(R.string.yemin_url)
                , 5, R.drawable.yemin_moshe));
        outDoorAttractions.add(new Attraction(getResources().getString(R.string.jaffa_name)
                , getResources().getString(R.string.jaffa_times)
                , getResources().getString(R.string.jaffa_summary)
                , getResources().getString(R.string.jaffa_description)
                , getResources().getString(R.string.jaffa_address)
                , getResources().getString(R.string.jaffa_url)
                , 4, R.drawable.jaffa_gate));

        // Find the RecyclerViw in the layout file
        recyclerView = rootView.findViewById(R.id.attractionsRecyclerView);
        // Create adapter passing in ArrayList as the data source
        attractionsAdapter = new AttractionsAdapter(outDoorAttractions);
        // Attach the adapter to the RecyclerView to populate items
        recyclerView.setAdapter(attractionsAdapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }

}
