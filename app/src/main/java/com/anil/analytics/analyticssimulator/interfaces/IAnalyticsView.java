package com.anil.analytics.analyticssimulator.interfaces;

import android.content.Context;

import com.anil.analytics.analyticssimulator.AnalyticsData;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by H211060 on 6/16/2018.
 */

public interface IAnalyticsView {
    Context getContext();
    void populateView(HashMap<String,HashMap<String,String>> analyticsData, ArrayList<AnalyticsData> data);
}
