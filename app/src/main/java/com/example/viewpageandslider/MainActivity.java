package com.example.viewpageandslider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;


public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2 ;
    private Button button ;

    private CircleIndicator3 circleIndicator;

    ArrayList<ViewPagerItem> viewPagerItemArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        button = findViewById(R.id.button);
        circleIndicator = findViewById(R.id.circleIndicator0);



        int[] images = {R.drawable.image1,R.drawable.image2,R.drawable.image3};
        String[] heading = {"Багровый","Рагна","Старлия"};
        String[] description =
                {
                  getString(R.string.Crimson),
                  getString(R.string.Ragna),
                  getString(R.string.Starlia)
                };
        viewPagerItemArrayList = new ArrayList<>();

        for (int i = 0; i<images.length ; i++){
            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i],heading[i],description[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }
        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);

        viewPager2.setAdapter(vpAdapter);

        viewPager2.setClipToPadding(false);

        viewPager2.setClipChildren(false);

        viewPager2.setOffscreenPageLimit(2);

        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        circleIndicator.setViewPager(viewPager2);

        button.setOnClickListener(v -> {


                int currentItem = viewPager2.getCurrentItem();
                int totalItems = viewPager2.getAdapter().getItemCount();
                // Перелистывание на следующую страницу
            if (currentItem < totalItems-1) {
                viewPager2.setCurrentItem(currentItem + 1, true);

            } else {
                Intent intent = new Intent(MainActivity.this , Slider.class);
                startActivity(intent);
            }
        });




    }
}