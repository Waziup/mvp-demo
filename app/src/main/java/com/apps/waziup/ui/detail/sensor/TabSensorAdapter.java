package com.apps.waziup.ui.detail.sensor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.R;
import com.apps.waziup.ui.detail.SensorMock;

import java.util.List;

/**
 * Created by KidusMT on 12/30/2017.
 */

public class TabSensorAdapter extends RecyclerView.Adapter<TabSensorViewHolder> {

    public Context context;
    private List<SensorMock> sensors;

    public TabSensorAdapter(List<SensorMock> sensorList, Context context) {
        this.sensors = sensorList;
        this.context = context;
    }

    @Override
    public TabSensorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.card_sensor, parent, false);
        return new TabSensorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TabSensorViewHolder holder, int position) {

        SensorMock sensor = this.sensors.get(position);
        holder.sensorReading.setText(String.valueOf(sensor.position));
        holder.sensorName.setText(sensor.name);
        holder.sensorType.setText(sensor.type);
//        Picasso.with(context).load(sensor.image).into(holder.sensorImg);
    }

    @Override
    public int getItemCount() {
        return  sensors.size();
    }
}
