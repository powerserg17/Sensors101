package com.serhiipianykh.sensors101;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by serhiipianykh on 2017-02-28.
 */

public class SensorsListFragment extends Fragment {

    private SensorManager sensorManager;
    private RecyclerView sensorsList;

    public static SensorsListFragment newInstance() {
        SensorsListFragment fragment = new SensorsListFragment();
        return fragment;
    }

    private List<Sensor> deviceSensors;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting reference to device sensor services
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        //list of all device sensors
        deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_sensors, container, false);

        sensorsList = (RecyclerView) v.findViewById(R.id.list_sensors_recycler_view);
        sensorsList.setHasFixedSize(true);

        sensorsList.setAdapter(new SensorItemAdapter(deviceSensors));
        sensorsList.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }
}
