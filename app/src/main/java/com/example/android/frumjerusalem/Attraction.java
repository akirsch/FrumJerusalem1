package com.example.android.frumjerusalem;

/**
 * Created by Owner on 4/18/2018.
 */


public class Attraction {

    // declare fields that will comprise object state
    private String attractionName;
    private String attractionOpeningHours;
    private String shortDescription;
    private String longDescription;
    private String attractionPhoneNumber = NO_NUMBER_PROVIDED;
    private String attractionAddress;
    private String attractionURL;
    private float attractionRating;
    private int attractionImageResourceID;

    /** Constant String value that represents no phone number was provided for this Attraction*/
    private static final String NO_NUMBER_PROVIDED = "no number";

    /**
     * Create a new Attraction Object
     * @param name name of attraction
     * @param openingHours opening hours of attraction
     * @param sDescription brief one line description of attraction
     * @param lDescription more detailed description of attraction
     * @param phoneNumber phone number of attraction
     * @param address attraction address
     * @param url attraction web address
     * @param rating rating of attraction
     * @param imageResourceID location of image resource for this attraction
     */
    public Attraction (String name, String openingHours, String sDescription, String lDescription,
    String phoneNumber, String address, String url, float rating, int imageResourceID ) {

        attractionName = name;
        attractionOpeningHours = openingHours;
        shortDescription = sDescription;
        longDescription = lDescription;
        attractionPhoneNumber = phoneNumber;
        attractionAddress = address;
        attractionURL = url;
        attractionRating = rating;
        attractionImageResourceID = imageResourceID;

    }

    /**
     * Create a new Attraction Object with no phone number
     * @param name name of attraction
     * @param openingHours opening hours of attraction
     * @param sDescription brief one line description of attraction
     * @param lDescription more detailed description of attraction
     * @param address attraction address
     * @param url attraction web address
     * @param rating rating of attraction
     * @param imageResourceID location of image resource for this attraction
     */
    public Attraction (String name, String openingHours, String sDescription, String lDescription,
                       String address, String url, float rating, int imageResourceID ) {

        attractionName = name;
        attractionOpeningHours = openingHours;
        shortDescription = sDescription;
        longDescription = lDescription;
        attractionAddress = address;
        attractionURL = url;
        attractionRating = rating;
        attractionImageResourceID = imageResourceID;

    }


    /**
     * Get the name of the attraction.
     */
    public String getAttractionName() {
        return attractionName;
    }

    /**
     * Get the opening times of the attraction.
     */
    public String getAttractionOpeningHours() {
        return attractionOpeningHours;
    }

    /**
     * Get the short description of the attraction.
     */
    public String getShortDescription() { return shortDescription; }

    /**
     * Get the long description of the attraction.
     */
    public String getLongDescription() { return longDescription; }

    /**
     * Get the phone number of the attraction.
     */
    public String getAttractionPhoneNumber() { return attractionPhoneNumber; }

    /**
     * Get the address of the attraction.
     */
    public String getAttractionAddress() { return attractionAddress; }

    /**
     * Get the rating of the attraction.
     */
    public float getAttractionRating() { return attractionRating; }

    /**
     * Get the url of the attraction.
     */
    public String getAttractionUrl() { return attractionURL; }

    /**
     * Get the image resource ID of the attraction.
     */
    public int getAttractionImageResourceID() { return attractionImageResourceID; }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasNoPhonenumber() {
        return attractionPhoneNumber.equals(NO_NUMBER_PROVIDED);
    }




}
