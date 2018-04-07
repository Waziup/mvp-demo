package com.apps.waziup.ui.detail.sensor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.waziup.R;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by KidusMT on 4/1/2018.
 */

public class TabSensorViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_sensor_card_reading)
    TextView sensorReading;
    @BindView(R.id.tv_sensor_card_title)
    TextView sensorName;
    @BindView(R.id.tv_sensor_card_type)
    TextView sensorType;
    @BindView(R.id.sensor_marker)
    ImageView sensorLocation;
    @BindView(R.id.iv_sensor_card_img)
    ImageView sensorImg;

    Unbinder unbinder;

    public TabSensorViewHolder(View itemView) {
        super(itemView);
        unbinder = ButterKnife.bind(this, itemView);
        sensorImg.setOnClickListener(
                v -> Toast.makeText(itemView.getContext(), "Sensor detail", Toast.LENGTH_SHORT).show());
        //40.482450, -75.178184
        sensorLocation.setOnClickListener(u -> {
            String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 40.482450, -75.178184);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            itemView.getContext().startActivity(intent);
        });

    }
}