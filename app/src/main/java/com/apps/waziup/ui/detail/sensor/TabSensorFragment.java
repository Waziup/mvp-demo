package com.apps.waziup.ui.detail.sensor;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.ui.detail.SensorMock;
import com.apps.waziup.waziup.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TabSensorFragment extends BaseFragment {

    @BindView(R.id.recycler_view_sensor)
    RecyclerView recyclerView;
    TabSensorAdapter adapter;
    List<SensorMock> sensorList;

    Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sensors, container, false);

        unbinder = ButterKnife.bind(this, v);

        sensorList = new ArrayList<>();
        adapter = new TabSensorAdapter(sensorList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

        prepareSensors();
        return v;
    }

    private void prepareSensors() {
        int[] covers = new int[]{
                R.drawable.sensor_1,
                R.drawable.sensor_2,
                R.drawable.sensor_3,
                R.drawable.sensor_4,
                R.drawable.sensor_5,
                R.drawable.sensor_6};

        SensorMock a = new SensorMock("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[0], "40.482450, -75.178184");
        sensorList.add(a);

        a = new SensorMock("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[1], "40.482450, -75.178184");
        sensorList.add(a);

        a = new SensorMock("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[2], "40.482450, -75.178184");
        sensorList.add(a);

        a = new SensorMock("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[3], "40.482450, -75.178184");
        sensorList.add(a);

        a = new SensorMock("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[4], "40.482450, -75.178184");
        sensorList.add(a);

        a = new SensorMock("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[5], "40.482450, -75.178184");
        sensorList.add(a);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
