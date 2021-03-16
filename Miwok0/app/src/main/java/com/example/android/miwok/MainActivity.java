/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity{

    private static final int NUM_PAGES = 4;
    TabLayout myTab;
    ViewPager myPage;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTab = (TabLayout) findViewById(R.id.tab);
        myPage = (ViewPager) findViewById(R.id.pager);

        myTab.addTab(myTab.newTab().setText("Tab 1"));
        myTab.addTab(myTab.newTab().setText("Tab 2"));
        myTab.addTab(myTab.newTab().setText("Tab 3"));

        setupViewPage(myPage);

        myTab.setTabTextColors(Color.parseColor("#d3d3d3"), Color.parseColor("#FFFFFF"));
        myTab.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));

        //Link TabLayout together with ViewPager
        myTab.setupWithViewPager(myPage);
    }

    public void setupViewPage (ViewPager viewPage){
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.addFragmentPage(new NumbersFragment(), "Numbers");
        adapter.addFragmentPage(new FamilyFragment(), "Family");
        adapter.addFragmentPage(new ColorsFragment(), "Colors");
        adapter.addFragmentPage(new PhrasesFragment(), "Phrases");

        //Set a PagerAdapter that will supply views for this pager as needed.
        viewPage.setAdapter(adapter);
    }

    public class ViewPageAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> pageTitle = new ArrayList<>();

        public ViewPageAdapter(FragmentManager manager){
            super(manager);
        }

        public void addFragmentPage(Fragment frag, String title){
            fragmentList.add(frag);
            pageTitle.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitle.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}