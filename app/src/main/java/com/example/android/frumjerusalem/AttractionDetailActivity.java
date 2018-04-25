package com.example.android.frumjerusalem;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class AttractionDetailActivity extends AppCompatActivity implements View.OnClickListener {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);

        // get all values passed by the intent
        bundle = getIntent().getExtras();

        // set views in layout to display the correct content
        ImageView detailImageView = findViewById(R.id.detail_image_view);
        detailImageView.setImageResource(bundle.getInt(Contstants.ATTRACTION_IMAGE_ID));

        TextView detailTimes = findViewById(R.id.attractiomName_opening_times);
        detailTimes.setText(bundle.getString(Contstants.ATTRACTION_TIMES));

        RatingBar ratingBar = findViewById(R.id.rating_bar);
        ratingBar.setRating(bundle.getFloat(Contstants.ATTRACTION_RATING));

        TextView detailAddressView = findViewById(R.id.location_address_view);
        detailAddressView.setText(bundle.getString(Contstants.ATTRACTION_ADRESS));

        TextView detailPhoneNumberView = findViewById(R.id.location_phone_number);
        TextView phoneActionIcon = findViewById(R.id.phone_action_icon);

        TextView detailDescriptionView = findViewById(R.id.description);
        detailDescriptionView.setText(bundle.getString(Contstants.ATTRACTION_DESCRIPTION));



        // if attraction doesn't have phone number, don't display phone icon and phone number views
        if (bundle.getString(Contstants.ATTRACTION_PHONE_NUMBER).equals(getResources().getString(R.string.noPhoneNumber))){
            detailPhoneNumberView.setVisibility(View.GONE);
            phoneActionIcon.setVisibility(View.GONE);
        } else {
            detailPhoneNumberView.setText(bundle.getString(Contstants.ATTRACTION_PHONE_NUMBER));
            detailPhoneNumberView.setVisibility(View.VISIBLE);
            phoneActionIcon.setVisibility(View.VISIBLE);

            //set click listener on phone icon and phone number views
            phoneActionIcon.setOnClickListener(this);
            detailPhoneNumberView.setOnClickListener(this);
        }

        // set click listener on web icon view
        TextView webIconView = findViewById(R.id.web_icon_view);
        webIconView.setOnClickListener(this);

        // Enable up navigation to parent Activity
        // find Toolbar view in layout
        Toolbar myToolbar = findViewById(R.id.toolbar);
        // Set the Toolbar as Action Bar
        setSupportActionBar(myToolbar);
        // enable up navigation to parent activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //set app bar title to match name of selected attraction
        getSupportActionBar().setTitle(bundle.get(Contstants.ATTRACTION_NAME).toString());
        // set status bar to be transparent
        getWindow().setStatusBarColor(Color.TRANSPARENT);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.phone_action_icon || view.getId() == R.id.location_phone_number){
            dialPhoneNumber(bundle.getString(Contstants.ATTRACTION_PHONE_NUMBER));
        }
        else if (view.getId() == R.id.web_icon_view){
            openWebPage(bundle.getString(Contstants.ATTRACTION_URL));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method dials number of the attraction in phone's phone call app
     * @param phoneNumber phone number of attraction
     */
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method opens the homepage of the attraction webpage
     * @param url web address of attraction
     */
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
