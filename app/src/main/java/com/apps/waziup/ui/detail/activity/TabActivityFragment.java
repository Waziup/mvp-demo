package com.apps.waziup.ui.detail.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.waziup.base.view.BaseFragment;
import com.apps.waziup.ui.create.CreateProjectContract;
import com.apps.waziup.waziup.R;

/**
 * Created by KidusMT on 3/31/2018.
 */

public class TabActivityFragment extends BaseFragment implements TabActivityContract.View {

//    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_activity,container, false);

//        recyclerView = v.findViewById(R.id.recycler_view_home);
//
//
////        adapter = new AccidentAdapter(getContext(),accidents);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//
//        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void attachPresenter(CreateProjectContract.Presenter presenter) {

    }

    @Override
    public void close() {
        getActivity().finish();
    }
}