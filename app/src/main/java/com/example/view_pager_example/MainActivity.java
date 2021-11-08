package com.example.view_pager_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.view_pager_example.view_pager.OutBoardingFragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private ViewPager viewPager;
//    private OutBoardingViewPagerAdapter viewPagerAdapter;

    private ViewPager2 viewPager;
    private OutBoardingFragmentStateAdapter viewPagerAdapter;

    private ImageButton next;
    private ImageButton previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initializeViewPager();
    }

    private void findViews() {
        viewPager = findViewById(R.id.out_boarding_view_pager);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);

        next.setOnClickListener(this);
        previous.setOnClickListener(this);
    }

    private void initializeViewPager() {
//        viewPagerAdapter = new OutBoardingViewPagerAdapter(this);
//        viewPager.setAdapter(viewPagerAdapter);

        viewPagerAdapter = new OutBoardingFragmentStateAdapter(this, getFragmentsList());
        viewPager.setAdapter(viewPagerAdapter);
    }

    List<OutBoardingFragment> getFragmentsList() {
        List<OutBoardingFragment> outBoardingFragments = new ArrayList<>();
        outBoardingFragments.add(OutBoardingFragment.newInstance("Title 1", "SubTitle"));
        outBoardingFragments.add(OutBoardingFragment.newInstance("Title 2", "SubTitle"));
        outBoardingFragments.add(OutBoardingFragment.newInstance("Title 3", "SubTitle"));
        return outBoardingFragments;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next) {
            if (viewPager.getCurrentItem() < 2)
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        } else if (v.getId() == R.id.previous) {
            if (viewPager.getCurrentItem() > 0)
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
        }
    }
}