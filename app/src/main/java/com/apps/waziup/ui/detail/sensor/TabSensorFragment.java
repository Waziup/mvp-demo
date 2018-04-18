package com.apps.waziup.ui.detail.sensor;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.ui.create.CreateSensorContract;
import com.apps.waziup.ui.detail.SensorMock;
import com.apps.waziup.ui.detail.entity.TabEntityContract;
import com.apps.waziup.waziup.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TabSensorFragment extends BaseFragment implements TabEntityContract.View{

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
                R.drawable.decagon_sensor,
                R.drawable.emb5_sensor,
               };

        SensorMock a = new SensorMock("ML3 ThetaProbe ",
                "soil moisture measurements.",
                "soil moisture", covers[0], "-40.482450, 40.178184"+getString(R.string.celsius));
        sensorList.add(a);

        a = new SensorMock("Decagon 5TE Sensor",
                "Measure the water  content , electrical  conductivity and temperature  of the soil",
                "Soil", covers[1], "-40.482450, 60.178184"+getString(R.string.celsius));
        sensorList.add(a);

        a = new SensorMock("Em5B Analog Data Logger",
                "add inexpensive peripheral sites to a study.Perfect for a season’s worth of basic soil moisture data",
                "Soil", covers[2], "-45.184, 5.00 "+getString(R.string.celsius));
        sensorList.add(a);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void attachPresenter(CreateSensorContract.Presenter presenter) {

    }

    @Override
    public void close() {

    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onUnknownError(String error) {

    }

    @Override
    public void onTimeout() {

    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {

    }
}
