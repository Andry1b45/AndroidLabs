package com.kpi.Lab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_fragment_layout, container, false);
    }

    public void setSelectedItem(String result) {
        TextView view =  getView().findViewById(R.id.result);
        view.setText(result);
    }
}