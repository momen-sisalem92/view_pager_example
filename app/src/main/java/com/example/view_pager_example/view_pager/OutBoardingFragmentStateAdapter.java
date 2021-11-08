package com.example.view_pager_example.view_pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.view_pager_example.OutBoardingFragment;
import com.example.view_pager_example.R;

import java.util.List;

public class OutBoardingFragmentStateAdapter extends FragmentStateAdapter {

    private Context context;
    List<OutBoardingFragment> fragments;

    public OutBoardingFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity, List<OutBoardingFragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}