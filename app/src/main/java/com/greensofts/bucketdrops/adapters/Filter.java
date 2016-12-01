package com.greensofts.bucketdrops.adapters;

/**
 * Created by Steven Nguyen on 11/30/2016.
 */

public interface Filter {
    int NONE = 0;
    int MOST_TIME_LEFT = 1;
    int LEAST_TIME_LEFT = 2;
    int COMPLETE = 3;
    int INCOMPLETE = 4;
}
