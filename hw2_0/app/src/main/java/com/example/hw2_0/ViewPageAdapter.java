package com.example.hw2_0;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentStateAdapter {
    private List<String> urls = new ArrayList<>();

    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void addTab(String url) {
        urls.add(url);
        notifyDataSetChanged();
    }


    public String getUrl(int position) {
        return urls.get(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return Tabs.newInstance(getUrl(position));
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }
}
