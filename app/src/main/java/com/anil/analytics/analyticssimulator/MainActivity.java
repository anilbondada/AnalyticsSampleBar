package com.anil.analytics.analyticssimulator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.anil.analytics.analyticssimulator.interfaces.IAnalyticsPresenter;
import com.anil.analytics.analyticssimulator.interfaces.IAnalyticsView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements IAnalyticsView{
    BarChart barChart;
    IAnalyticsPresenter presenter;
    Button refresh;
    boolean refreshToggle = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.generateAnalyticsData();
            }
        });
        barChart = (BarChart) findViewById(R.id.chart);
        presenter = new AnalyticsPresenter(this);
        presenter.generateAnalyticsData();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void populateView(HashMap<String, HashMap<String, String>> analyticsData,ArrayList<AnalyticsData> analyticsDataList) {
        if(refreshToggle){
            populateAnalyticsWith(analyticsDataList);
            refreshToggle = false;
        }
        else {
            populateAnalyticsWith(analyticsData);
            refreshToggle = true;
        }
    }

    private void populateAnalyticsWith(ArrayList<AnalyticsData> analyticsDataList){

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int dataLevel =0 ;dataLevel < analyticsDataList.size();dataLevel++) {
            HashMap<String,String> data1 = analyticsDataList.get(dataLevel).getEventData();
            entries.add(new BarEntry(Float.parseFloat(data1.get("userID")), dataLevel));
        }

        BarDataSet dataset = new BarDataSet(entries, "# of userID");
        ArrayList<String> labels = new ArrayList<String>();
        /*labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");*/


        for (int dataLevel =0 ;dataLevel < analyticsDataList.size();dataLevel++) {
            HashMap<String,String> data1 = analyticsDataList.get(dataLevel).getEventData();
            String key = data1.get("deviceType");
            labels.add(key);

        }
        barChart.clear();
        BarData data = new BarData(labels, dataset);
        barChart.setData(data); // set the data and list of lables into chart
        barChart.setDescription("Analytics Data");

    }



    private void populateAnalyticsWith(HashMap<String, HashMap<String, String>> analyticsData){

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int dataLevel =0 ;dataLevel < analyticsData.keySet().size();dataLevel++) {

            entries.add(new BarEntry(Float.parseFloat(analyticsData.get(analyticsData.keySet().toArray()[dataLevel]).get("userID")), dataLevel));
/*
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));
*/
        }

        BarDataSet dataset = new BarDataSet(entries, "# of userID");
        ArrayList<String> labels = new ArrayList<String>();
        /*labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");*/


        for (int dataLevel =0 ;dataLevel < analyticsData.keySet().size();dataLevel++) {
            String key = analyticsData.get(analyticsData.keySet().toArray()[dataLevel]).get("deviceType");
            labels.add(key);

        }
        BarData data = new BarData(labels, dataset);
        barChart.clear();
        barChart.setData(data); // set the data and list of lables into chart
        barChart.setDescription("Analytics with Hash Data");

    }

}
