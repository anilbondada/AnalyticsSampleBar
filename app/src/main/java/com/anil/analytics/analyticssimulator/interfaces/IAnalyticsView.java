package com.anil.analytics.analyticssimulator.interfaces;

import android.content.Context;

import com.anil.analytics.analyticssimulator.AnalyticsData;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anil Bondada on 6/5/2019.
 */

public interface IAnalyticsView {
    Context getContext();
    void populateView(HashMap<String,HashMap<String,String>> analyticsData, ArrayList<AnalyticsData> data);
}
