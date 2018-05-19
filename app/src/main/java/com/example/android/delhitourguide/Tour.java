package com.example.android.delhitourguide;

/**
 * Created by sahil on 27/2/18.
 */

public class Tour {
    private int mImageResourceId;
    private String mPlace;
    private String mPlaceDescription;

    public Tour(int imageResourceId, String place, String placeDescription) {
        mImageResourceId = imageResourceId;
        mPlace = place;
        mPlaceDescription = placeDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmPlace() {
        return mPlace;
    }

    public String getmPlaceDescription() {
        return mPlaceDescription;
    }
}
