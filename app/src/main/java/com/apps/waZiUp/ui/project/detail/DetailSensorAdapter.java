package com.apps.waZiUp.ui.project.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.apps.waZiUp.data.sensor.Sensor;
import com.apps.waZiUp.waziup.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

/**
 * Created by KidusMT on 12/30/2017.
 */

public class DetailSensorAdapter extends RecyclerView.Adapter<DetailSensorAdapter.MyViewHolder> {

    private List<Sensor> sensorList;
    public Context context;

    public DetailSensorAdapter(List<Sensor> sensorList, Context context) {
        this.sensorList = sensorList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_sensor, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Sensor sensor = sensorList.get(position);

        holder.sensorName.setText(sensor.name);
        holder.sensorType.setText(sensor.type);

        Picasso.with(context).load(R.drawable.sensor_2).into(holder.sensorImg);

    }

    @Override
    public int getItemCount() {
        return  sensorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView sensorName, sensorType;
        public ImageView sensorImg, sensorLocation;

        public MyViewHolder(View itemView) {
            super(itemView);
            sensorImg = itemView.findViewById(R.id.iv_sensor_card_img);
            sensorName = itemView.findViewById(R.id.tv_sensor_card_title);
            sensorType = itemView.findViewById(R.id.tv_sensor_card_type);
            sensorLocation = itemView.findViewById(R.id.sensor_marker);

            sensorImg.setOnClickListener(
                    v-> Toast.makeText(context, "Sensor detail", Toast.LENGTH_SHORT).show());
            //40.482450, -75.178184
            sensorLocation.setOnClickListener(u->{
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 40.482450, -75.178184);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);
            });

        }
    }
}
