package com.example.android.frumjerusalem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Owner on 4/18/2018.
 */

public class AttractionsAdapter extends
        RecyclerView.Adapter<AttractionsAdapter.ViewHolder> {

    private final String noNumberListed = "No phone Number";


    public class ViewHolder extends RecyclerView.ViewHolder {


        // Provide a direct reference to each of the views within a data item
        // Used to cache the views within the item layout for fast access
        public View view;
        public ImageView locationImageView;
        public TextView locationNameView;
        public RatingBar locationRatingView;
        public TextView openingTimesView;
        public TextView summaryView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder (View itemView){
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            view = itemView;
            locationImageView = itemView.findViewById(R.id.location_image);
            locationNameView = itemView.findViewById(R.id.location_name);
            locationRatingView = itemView.findViewById(R.id.rating_bar);
            openingTimesView = itemView.findViewById(R.id.opening_hours);
            summaryView = itemView.findViewById(R.id.short_description_view);
        }

    }



    // Store a member variable for the Attractions
    final private List<Attraction> attractionList;

    // Pass in the contact array into the constructor
    public AttractionsAdapter(List<Attraction> attractions) {
        attractionList = attractions;
    }

    @Override
    public AttractionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(AttractionsAdapter.ViewHolder viewHolder, final int position) {
        // Get the data model based on position
        Attraction attraction = attractionList.get(position);

        // Set item views based on your views and data model
        final ImageView imageView = viewHolder.locationImageView;
        imageView.setImageResource(attraction.getAttractionImageResourceID());

        TextView nameView = viewHolder.locationNameView;
        nameView.setText(attraction.getAttractionName());

        RatingBar ratingBar = viewHolder.locationRatingView;
        ratingBar.setRating(attraction.getAttractionRating());

        TextView openingHoursView = viewHolder.openingTimesView;
        openingHoursView.setText(attraction.getAttractionOpeningHours());

        TextView attractionSummaryView = viewHolder.summaryView;
        attractionSummaryView.setText(attraction.getShortDescription());

        // create click listener which will display a details page about the clicked on attraction
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pass to the intent the sate of the attraction to be displayed ii details activity
                int attractionImageId = attractionList.get(position).getAttractionImageResourceID();
                float atrractionRating = attractionList.get(position).getAttractionRating();
                String attractionName = attractionList.get(position).getAttractionName();
                String attractionAddress = attractionList.get(position).getAttractionAddress();
                String attractionPhoneNumber = attractionList.get(position).getAttractionPhoneNumber();
                String attractionUrl = attractionList.get(position).getAttractionUrl();
                String attractionTimes = attractionList.get(position).getAttractionOpeningHours();
                String attractionDescription = attractionList.get(position).getLongDescription();

                Context context = view.getContext();
                Intent intent = new Intent(context, AttractionDetailActivity.class);
                intent.putExtra(Contstants.ATTRACTION_IMAGE_ID, attractionImageId);
                intent.putExtra(Contstants.ATTRACTION_NAME, attractionName);
                intent.putExtra(Contstants.ATTRACTION_URL, attractionUrl);
                intent.putExtra(Contstants.ATTRACTION_RATING, atrractionRating);
                intent.putExtra(Contstants.ATTRACTION_TIMES, attractionTimes);
                intent.putExtra(Contstants.ATTRACTION_DESCRIPTION, attractionDescription);
                // only pass phone number with intent if relevant
                intent.putExtra(Contstants.ATTRACTION_ADRESS, attractionAddress);
                if (!attractionList.get(position).hasNoPhonenumber()){
                    intent.putExtra(Contstants.ATTRACTION_PHONE_NUMBER, attractionPhoneNumber);
                } else {
                    intent.putExtra(Contstants.ATTRACTION_PHONE_NUMBER, noNumberListed);
                }

                context.startActivity(intent);
            }
        });

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return attractionList.size();
    }
}
