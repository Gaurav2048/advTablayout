package com.example.advtablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);
        tablayout.setTabRippleColor(null);
        viewPager.setAdapter(new SimpleFragmentPagerAdapter(getApplicationContext(), getSupportFragmentManager()));
        tablayout.setupWithViewPager(viewPager);

        for(int i =0; i<tablayout.getTabCount(); i++){
            LinearLayout shape = (LinearLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_tabs, null);
            TextView textView = shape.findViewById(R.id.text);
            textView.setText(tablayout.getTabAt(i).getText());
            tablayout.getTabAt(i).setCustomView(shape);
        }

        HighlightTab(0);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                HighlightTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                FadeTab(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

        public void FadeTab(int position){
        LinearLayout tabShape = (LinearLayout) tablayout.getTabAt(position).getCustomView();
        TextView text = tabShape.findViewById(R.id.text);
        ImageView back = tabShape.findViewById(R.id.back);
        ImageView front = tabShape.findViewById(R.id.front);

        back.setVisibility(View.INVISIBLE);
        front.setVisibility(View.INVISIBLE);

        tabShape.setBackgroundResource(0);

    }

    public void HighlightTab(final int position){
        LinearLayout tabShape = (LinearLayout) tablayout.getTabAt(position).getCustomView();
        TextView text = tabShape.findViewById(R.id.text);
        ImageView back = tabShape.findViewById(R.id.back);
        ImageView front = tabShape.findViewById(R.id.front);

        back.setVisibility(View.VISIBLE);
        front.setVisibility(View.VISIBLE);

        tabShape.setBackgroundResource(R.drawable.tab_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position!= 0){
                    tablayout.getTabAt(position-1).select();
                }
            }
        });

        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position != tablayout.getTabCount()-1){
                    tablayout.getTabAt(position+1).select();
                }
            }
        });

    }

}
