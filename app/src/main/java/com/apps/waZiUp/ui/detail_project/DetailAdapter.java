package com.apps.waZiUp.ui.detail_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;

/**
 * Created by KidusMT on 12/30/2017.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {

    private List<Accident> accidentList;
    private DetailContract.Presenter presenter;

    public DetailAdapter(List<Accident> accidentList, HomeContract.Presenter presenter) {
        this.presenter = presenter;
        this.accidentList = accidentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.record_card, parent, false);
        return new MyViewHolder(itemView, presenter);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Accident accident = accidentList.get(position);
        Log.e("---->onBindViewHolder",""+accidentList.size());
        Log.e("---->onBindViewHolder",accident.getLocation());

        holder.accidentLocation.setText(accident.getLocation());
        holder.accidentDate.setText(accident.getDate());

        File imgFile = new File(accident.getImgPath());

        if (imgFile.exists()) {

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getPath());

            holder.accidentImg.setImageBitmap(myBitmap);

        }


    }

    @Override
    public int getItemCount() {
        return (accidentList != null) ? accidentList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView accidentLocation, accidentDate;//,accidentPlateNumber,accidentDescription;
        public ImageView accidentImg, delete_accident;

        public MyViewHolder(View itemView, final HomeContract.Presenter presenter) {
            super(itemView);
            accidentImg = itemView.findViewById(R.id.iv_movie_card_poster);
            accidentLocation = itemView.findViewById(R.id.tv_movie_card_title);
            accidentDate = itemView.findViewById(R.id.tv_movie_card_rating);
            delete_accident = itemView.findViewById(R.id.delete_rec);

            accidentImg.setOnClickListener(
                    v-> presenter.onAccidentClicked(getAdapterPosition()));

            delete_accident.setOnClickListener(v-> Toast.makeText(accidentImg.getContext(),
                    "don't have time now", Toast.LENGTH_SHORT).show());
        }
    }
}
