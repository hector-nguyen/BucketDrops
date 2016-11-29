package com.greensofts.bucketdrops.extras;

import android.view.View;

import java.util.List;

/**
 * Created by Steven Nguyen on 11/29/2016.
 */

public class Util {
    public static void showViews(List<View> views){
        for(View view : views){
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views){
        for(View view : views){
            view.setVisibility(View.GONE);
        }
    }
}
