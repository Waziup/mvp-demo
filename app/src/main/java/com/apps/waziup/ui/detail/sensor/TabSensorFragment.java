package com.apps.waziup.ui.detail.sensor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.data.BoxStoreProvider;
import com.apps.waziup.data.model.Sensor;
import com.apps.waziup.data.repo.sensor.SensorRepo;
import com.apps.waziup.data.repo.sensor.local.SensorLocal;
import com.apps.waziup.data.repo.sensor.remote.SensorRemote;
import com.apps.waziup.ui.detail.ProjectDetailActivity;
import com.apps.waziup.ui.detail.SensorMock;
import com.apps.waziup.ui.sensor.SensorActivity;
import com.apps.waziup.util.Utils;
import com.apps.waziup.waziup.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TabSensorFragment extends BaseFragment implements TabSensorContract.View{

    @BindView(R.id.recycler_view_sensor)
    RecyclerView recyclerView;
    @BindView(R.id.tab_sensor_progress_wheel)
    ProgressWheel progressWheel;
    private TabSensorAdapter adapter;
    private List<Sensor> sensorList;
    private TabSensorContract.Presenter presenter;

    private Unbinder unbinder;

    public String domain_id = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        domain_id = ProjectDetailActivity.domain_id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sensors, container, false);

        unbinder = ButterKnife.bind(this, v);

        presenter = new TabSensorPresenter(new SensorRepo(
                new SensorLocal(BoxStoreProvider.getStore()),
                new SensorRemote(getActivity())
        ));

        sensorList = new ArrayList<>();
        adapter = new TabSensorAdapter(sensorList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

//        prepareSensors();

        return v;
    }

//    private void prepareSensors() {
//        int[] covers = new int[]{
//                R.drawable.sensor_1,
//                R.drawable.decagon_sensor,
//                R.drawable.emb5_sensor,
//               };
//
//        SensorMock a = new SensorMock("ML3 ThetaProbe ",
//                "soil moisture measurements.",
//                "soil moisture", covers[0], "-40.482450, 40.178184"+getString(R.string.celsius));
//        sensorList.add(a);
//
//        a = new SensorMock("Decagon 5TE Sensor",
//                "Measure the water  content , electrical  conductivity and temperature  of the soil",
//                "Soil", covers[1], "-40.482450, 60.178184"+getString(R.string.celsius));
//        sensorList.add(a);
//
//        a = new SensorMock("Em5B Analog Data Logger",
//                "add inexpensive peripheral sites to a study.Perfect for a season’s worth of basic soil moisture data",
//                "Soil", covers[2], "-45.184, 5.00 "+getString(R.string.celsius));
//        sensorList.add(a);
//
//        adapter.notifyDataSetChanged();
//    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void attachPresenter(TabSensorContract.Presenter presenter) {

    }

    @Override
    public void close() {

    }

    @Override
    public void showLoading(String message) {
        progressWheel.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        progressWheel.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressWheel.setVisibility(View.GONE);
    }

    @Override
    public void onUnknownError(String error) {
        Utils.toastLong(getActivity(), error);
    }

    @Override
    public void onTimeout() {
        Utils.toastLong(getActivity(), "connection timeout");
    }

    @Override
    public void onNetworkError() {
        Utils.toastLong(getActivity(), "network error");
    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void onConnectionError() {
        Utils.toastLong(getActivity(), "connection error");
    }

    @Override
    public void onDetach() {
        unbinder.unbind();
        super.onDetach();
    }

    @Override
    public void showSensors(List<Sensor> sensorList) {
        adapter.updateSensorList(sensorList);
    }

    @Override
    public void showSensorDetailActivity(int sensorPosition) {
        //TODO uncomment after checking everything is working fine
//        Intent intent = new Intent(getActivity(), SensorActivity.class);
//        intent.putExtra("sensor", sensorPosition);
//        startActivity(intent);
    }
}
