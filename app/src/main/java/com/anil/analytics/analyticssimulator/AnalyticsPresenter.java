package com.anil.analytics.analyticssimulator;

import com.anil.analytics.analyticssimulator.interfaces.IAnalyticsPresenter;
import com.anil.analytics.analyticssimulator.interfaces.IAnalyticsView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by H211060 on 6/16/2018.
 */

public class AnalyticsPresenter implements IAnalyticsPresenter {
    IAnalyticsView view;
    ArrayList<AnalyticsData> analyticsData;
    HashMap<String,HashMap<String,String>> accumulatedData;
    AnalyticsPresenter(IAnalyticsView view){
        this.view = view;

    }
    @Override
    public void generateAnalyticsData() {
        analyticsData = new ArrayList<>();
        accumulatedData = new HashMap<>();
        for (int i=0; i<10000; i++) {
            // generate event names
            String eventType = Math.random() < 0.5 ?
                    "Session" : (Math.random() < 0.5 ? "Login" : "MatchStart");
            // create attributes to send
            HashMap<String, String> attributes = new HashMap<String,String>();
            attributes.put("userID", "" + (int)(Math.random()*10000));
            attributes.put("deviceType", Math.random() < 0.5 ?
                    "Android" : (Math.random() < 0.5 ? "iOS" : "Web"));
            // send the event
            addEvent(eventType, attributes);
        }
        view.populateView(accumulatedData,analyticsData);
    }

    private void addEvent(String eventType, HashMap<String, String> attributes) {
        analyticsData.add(new AnalyticsData(eventType,attributes));
        accumulatedData.put(eventType,attributes);
    }
}
