package com.anil.analytics.analyticssimulator;

import java.util.HashMap;

/**
 * Created by H211060 on 6/16/2018.
 */

public class AnalyticsData {
    public String getEventType() {
        return eventType;
    }

    public HashMap<String, String> getEventData() {
        return eventData;
    }

    String eventType;
    HashMap<String,String>eventData;
    AnalyticsData(String eventType,    HashMap<String,String>eventData){
        this.eventData = eventData;
        this.eventType = eventType;
    }
}
