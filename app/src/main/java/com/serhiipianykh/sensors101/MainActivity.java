package com.serhiipianykh.sensors101;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView sensorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorsList = (TextView) findViewById(R.id.sensors_list);

        //getting reference to device sensor services
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //list of all device sensors
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        //all items to textview
        for (int i = 0; i < deviceSensors.size(); i++) {
            sensorsList.append(deviceSensors.get(i).getName() + "\n");
        }
    }
}
