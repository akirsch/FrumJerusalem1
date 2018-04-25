package com.example.android.frumjerusalem;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by Owner on 4/14/2018.
 */

public class CategoryAdapter extends FragmentStatePagerAdapter {

    /** Context of the app */
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OutdoorsFragment();
            case 1:
                return new IndoorsFragment();
            case 2:
                return new ParksFragment();
            case 3:
                return new RestaurantsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_outdoors);
        } else if (position == 1) {
            return mContext.getString(R.string.category_indoors);
        } else if (position == 2) {
            return mContext.getString(R.string.category_parks);
        } else {
            return mContext.getString(R.string.category_restaurants);
        }

    }

}
