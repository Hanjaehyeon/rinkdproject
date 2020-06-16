package com.example.rinkdproject.coffee.cafelatte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.rinkdproject.R;
import com.example.rinkdproject.cafeacticity.Ediya.EdiyaPlaceFragment;
import com.example.rinkdproject.coffee.Drink;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class CafelatteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Drink> arrayList;
    private FirebaseDatabase database;

    TextView textView;
    Query query;

    private DatabaseReference databaseReference;
    private ViewPager viewPager;
//    HorizontalScrollView sv = (HorizontalScrollView)findViewById(R.id.scrollView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //sv.smoothScrollTo(500,0);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("카페라떼"));
        tabLayout.addTab(tabLayout.newTab().setText("콜드브루"));
        tabLayout.addTab(tabLayout.newTab().setText("티라미수"));
        tabLayout.addTab(tabLayout.newTab().setText("연유"));
        tabLayout.addTab(tabLayout.newTab().setText("헤이즐넛"));
        tabLayout.addTab(tabLayout.newTab().setText("말차"));
        tabLayout.addTab(tabLayout.newTab().setText("흑당"));

        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        final ViewPager viewpager = (ViewPager) findViewById(R.id.viewPager);
        final CafelatteActivity.PagerAdapter adapter = new CafelatteActivity.PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }

    private class PagerAdapter extends FragmentPagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        //getItem메서드를 생성하여 해당 프래그먼트를 각각의 tab화면에 표시하도록 해준다.
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    CaffeLatteCaffelatteFragment tab1 = new CaffeLatteCaffelatteFragment();
                    return tab1;
                case 1:
                    CafeLatteColdbrewFragment tab2 = new CafeLatteColdbrewFragment();
                    return tab2;
                case 2:
                    CafeLatteTiramisuFragment tab3 = new CafeLatteTiramisuFragment();
                    return tab3;
                case 3:
                    CafeLatteYeonyuFragment tab4 = new CafeLatteYeonyuFragment();
                    return tab4;
                case 4:
                    CafeLatteHeizlenutFragment tab5 = new CafeLatteHeizlenutFragment();
                    return tab5;
                case 5:
                    CafeLatteGreenteaFragment tab6 = new CafeLatteGreenteaFragment();
                    return tab6;
                case 6:
                    CafeLatteSugarFragment tab7 = new CafeLatteSugarFragment();
                    return tab7;
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

}
