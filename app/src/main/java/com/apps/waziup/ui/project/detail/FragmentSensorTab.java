package com.apps.waziup.ui.project.detail;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.data.sensor.Sensor;
import com.apps.waziup.waziup.R;

import java.util.List;

public class FragmentSensorTab extends BaseFragment {

    private RecyclerView recyclerView;
    private DetailSensorAdapter adapter;
    List<Sensor> sensorList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sensors, container, false);

//        recyclerView = v.findViewById(R.id.recycler_view_sensor);
//
//        sensorList = new ArrayList<>();
//        adapter = new DetailSensorAdapter(sensorList, getContext());
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//
//        recyclerView.setAdapter(adapter);
//
//        prepareSensors();
        return v;
    }

    /**
     * This is a static data values for showing the UI of the app. Just a mock data
     * for the recyclerViews.
     */
    private void prepareSensors() {
        int[] covers = new int[]{
                R.drawable.sensor_1,
                R.drawable.sensor_2,
                R.drawable.sensor_3,
                R.drawable.sensor_4,
                R.drawable.sensor_5,
                R.drawable.sensor_6};

        Sensor a = new Sensor("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[0],"40.482450, -75.178184");
        sensorList.add(a);

        a = new Sensor("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[1],"40.482450, -75.178184");
        sensorList.add(a);

        a = new Sensor("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[2],"40.482450, -75.178184");
        sensorList.add(a);

        a = new Sensor("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[3],"40.482450, -75.178184");
        sensorList.add(a);

        a = new Sensor("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[4],"40.482450, -75.178184");
        sensorList.add(a);

        a = new Sensor("PheNode",
                "PheNode is a tool for researchers, farmers and horticulturists that can monitor environmental conditions and transmits the data to the cloud where growers can track their plants in real-time in order to facilitate data-driven decision support.",
                "Temprature", covers[5],"40.482450, -75.178184");
        sensorList.add(a);
    }

    @Override
    public void onResume() {
        super.onResume();
//        adapter.notifyDataSetChanged();
    }
}
