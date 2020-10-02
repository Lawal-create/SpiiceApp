package com.example.spiiceapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class FeedFragment extends Fragment {
    BarChart barChart;
    Button viewAll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_feed, container, false);
        barChart=view.findViewById(R.id.chart);

        ArrayList<BarEntry> entries=new ArrayList<>();
        entries.add(new BarEntry(2f, (float) 4.6));
        entries.add(new BarEntry(3f, (float) 4.8));
        entries.add(new BarEntry(4f,5));
        entries.add(new BarEntry(5f, (float) 4.8));

        BarDataSet barDataSet=new BarDataSet(entries,"");
        BarData bardata=new BarData(barDataSet);
        bardata.setBarWidth(0.7f);
        barChart.setData(bardata);

        barChart.setDescription(null);
        barChart.getXAxis().setEnabled(false);
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisLeft().setDrawAxisLine(false);
        barChart.getAxisRight().setDrawAxisLine(false);
        barChart.getAxisRight().setEnabled(false);
        barDataSet.setColors(new int[]{Color.rgb(251,234,255),Color.rgb(251,234,255),Color.rgb(251,234,255),Color.rgb(147,120,255)});


        viewAll=view.findViewById(R.id.viewAll);
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert getFragmentManager() != null;
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_container,new DetailFeedFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
