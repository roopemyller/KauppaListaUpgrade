package com.example.kauppalistaupgrade;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.kauppalistaupgrade.fragments.List;
import com.example.kauppalistaupgrade.fragments.NewListItem;

public class TabPagerAdapter extends FragmentStateAdapter {
    private TabActivity tabActivity;
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity, TabActivity tabActivity ) {
        super(fragmentActivity);
        this.tabActivity = tabActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new List();
            case 0:
            default:
                return new NewListItem(tabActivity);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
