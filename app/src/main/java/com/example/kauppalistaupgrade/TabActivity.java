package com.example.kauppalistaupgrade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kauppalistaupgrade.fragments.ImportantList;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 fragmentArea;
    private TabPagerAdapter tabPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        setupTabLayout();

        runImportantFragment();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }

    public void runImportantFragment(){
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.importantFragmentView, ImportantList.class, null)
                .commit();
    }

    public void setupTabLayout(){
        tabLayout = findViewById(R.id.tabLayout);
        fragmentArea = findViewById(R.id.fragmentArea);
        tabPagerAdapter = new TabPagerAdapter(this, this);
        fragmentArea.setAdapter(tabPagerAdapter);
    }
}