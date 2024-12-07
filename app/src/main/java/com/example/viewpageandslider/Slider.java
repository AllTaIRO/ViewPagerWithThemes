package com.example.viewpageandslider;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;

public class Slider extends AppCompatActivity {

    private ViewPager2 viewPager;
    private CircleIndicator3 circleIndicator;
    private Handler handler;
    private Runnable runnable;

    int currentItem;
    private ArrayList<Slideritem> slideritemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slider);

        viewPager = findViewById(R.id.viewPager);
        circleIndicator = findViewById(R.id.circleIndicator);

        int[] images = {R.drawable.cat1 , R.drawable.cat2 , R.drawable.cat3};

        slideritemArrayList = new ArrayList<>();

        for (int i = 0 ; i<images.length ; i++){
            Slideritem slideritem = new Slideritem(images[i]);
            slideritemArrayList.add(slideritem);
        }

        PhotoViewPagerAdapter photoViewPagerAdapter = new PhotoViewPagerAdapter(slideritemArrayList);

        viewPager.setAdapter(photoViewPagerAdapter);

        circleIndicator.setViewPager(viewPager);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                if (currentItem == images.length){
                    currentItem = 0;
                }
                viewPager.setCurrentItem(currentItem++ , true);
                handler.postDelayed(this , 3000);
            }
        };
        handler.postDelayed(runnable , 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,3000);
    }
}