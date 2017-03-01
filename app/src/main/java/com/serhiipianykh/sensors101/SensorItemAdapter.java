package com.serhiipianykh.sensors101;

import android.hardware.Sensor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by serhiipianykh on 2017-02-28.
 */

public class SensorItemAdapter extends RecyclerView.Adapter<SensorItemAdapter.SensorAdapterHolder> {

    private List<Sensor> sensors;

    public static class SensorAdapterHolder extends RecyclerView.ViewHolder {
        private final TextView sensorNameTextView;

        public SensorAdapterHolder(final View itemView) {
            super(itemView);
            sensorNameTextView = (TextView) itemView.findViewById(R.id.sensor_name);
        }

        public void bindSensor(Sensor sensor) {
            sensorNameTextView.setText(sensor.getName());
        }
    }

    public SensorItemAdapter(final List<Sensor> list) {
        this.sensors = list;
    }

    @Override
    public SensorItemAdapter.SensorAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sensor, parent, false);
        return new SensorAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(SensorItemAdapter.SensorAdapterHolder holder, int position) {
        final Sensor sensor = sensors.get(position);
        holder.bindSensor(sensor);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("TAG",String.valueOf(sensors.size()));
        return sensors.size();
    }
}
