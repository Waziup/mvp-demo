package com.apps.waziup.ui.create;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

/**
 * Created by KidusMT on 4/12/2018.
 */

public class NothingSelectedSpinnerAdapter implements SpinnerAdapter, ListAdapter {

    protected static final int EXTRA = 1;
    protected SpinnerAdapter adapter;
    protected Context context;
    protected int nothingSelectedLayout;
    protected int nothingSelectedDropDownLayout;
    protected LayoutInflater layoutInflater;

    public NothingSelectedSpinnerAdapter(SpinnerAdapter adapter, Context context, int nothingSelectedLayout) {
        this(adapter, context, nothingSelectedLayout, -1);
    }

    public NothingSelectedSpinnerAdapter(SpinnerAdapter adapter, Context context, int nothingSelectedLayout, int nothingSelectedDropDownLayout) {
        this.adapter = adapter;
        this.context = context;
        this.nothingSelectedLayout = nothingSelectedLayout;
        this.nothingSelectedDropDownLayout = nothingSelectedDropDownLayout;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return position != 0;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (position==0){
            return nothingSelectedDropDownLayout == -1 ? new View(context) : getNothingSelectedView(parent);
        }
        return adapter.getDropDownView(position - EXTRA, null, parent);
    }

    public View getNothingSelectedDropDownView(ViewGroup parent){
        return layoutInflater.inflate(nothingSelectedLayout, parent, false);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        adapter.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        adapter.unregisterDataSetObserver(observer);
    }

    @Override
    public int getCount() {
        int count = adapter.getCount();
        return count == 0? 0 : count + EXTRA;
    }

    @Override
    public Object getItem(int position) {
        return position == 0? null: adapter.getItem(position-EXTRA);
    }

    @Override
    public long getItemId(int position) {
        return position >= EXTRA? adapter.getItemId(position - EXTRA) : position - EXTRA;
    }

    @Override
    public boolean hasStableIds() {
        return adapter.hasStableIds();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position== 0){
            return getNothingSelectedView(parent);
        }
        return adapter.getView(position-EXTRA, null, parent);
    }

    protected View getNothingSelectedView(ViewGroup parent){
        return layoutInflater.inflate(nothingSelectedLayout, parent, false);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return adapter.isEmpty();
    }
}
