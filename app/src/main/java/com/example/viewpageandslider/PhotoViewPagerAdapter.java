package com.example.viewpageandslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class PhotoViewPagerAdapter extends RecyclerView.Adapter<PhotoViewPagerAdapter.ViewHolder> {

    ArrayList<Slideritem> slideritemArrayList;

    public PhotoViewPagerAdapter(ArrayList<Slideritem> slideritemArrayList) {
        this.slideritemArrayList = slideritemArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_test, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Slideritem slideritem = slideritemArrayList.get(position);
        holder.imageView.setImageResource(slideritem.imageID);

    }

    @Override
    public int getItemCount() {
        return slideritemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.SliderImage);
        }
    }


}
