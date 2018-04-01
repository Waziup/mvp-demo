package com.apps.waziup.ui.project.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.waziup.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by KidusMT on 12/30/2017.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {

    private List<SensorMock> sensorList;
    public Context context;

    public DetailAdapter(List<SensorMock> sensorList, Context context) {
        this.sensorList = sensorList;
        this.context = context;
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_sensor, parent, false);
        return new DetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {

        SensorMock sensor = sensorList.get(position);
        holder.sensorReading.setText(sensor.latitude+" "+sensor.longitude);
        holder.sensorName.setText(sensor.name);
        holder.sensorType.setText(sensor.type);
        Picasso.with(context).load(R.drawable.sensor_2).into(holder.sensorImg);

    }

    @Override
    public int getItemCount() {
        return  sensorList.size();
    }
}
