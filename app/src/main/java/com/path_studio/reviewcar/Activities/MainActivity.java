package com.path_studio.reviewcar.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.mancj.materialsearchbar.adapter.SuggestionsAdapter;
import com.path_studio.reviewcar.Adapter.ListMobilAdapter;
import com.path_studio.reviewcar.Adapter.slider_adapter;
import com.path_studio.reviewcar.Models.Mobil;
import com.path_studio.reviewcar.Models.MobilData;
import com.path_studio.reviewcar.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCars;
    private ArrayList<Mobil> list = new ArrayList<>();

    private MaterialSearchBar materialSearchBar;

    private BottomNavigationView bottomNavigationView;

    private slider_adapter slider_adapter;
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDosts;
    private int nCurrentPage;

    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //untuk view slider
        mSlideViewPager = (ViewPager) findViewById(R.id.carSlider);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayoutPromotion);

        slider_adapter = new slider_adapter(this);
        mSlideViewPager.setAdapter(slider_adapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //bagian Timer nya
        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (nCurrentPage == 4) { //karena mulai dari 0
                    nCurrentPage = 0;
                }
                mSlideViewPager.setCurrentItem(nCurrentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);



        //untuk bagian search
        materialSearchBar = findViewById(R.id.searchBar);
        setting_search();


        rvCars = findViewById(R.id.rv_cars);
        rvCars.setHasFixedSize(true);

        list.addAll(MobilData.getListData());
        showRecyclerList();

        //membuat bottom nav
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_home :
                        //menuju actiivity home
                        break;
                    case R.id.action_photos :
                        //menuju activity photos
                        break;
                    case R.id.action_about :
                        //menuju activity about
                        break;
                }

                return true;
            }
        });

    }

    private void showRecyclerList(){
        rvCars.setLayoutManager(new LinearLayoutManager(this));
        ListMobilAdapter listHeroAdapter = new ListMobilAdapter(list);
        rvCars.setAdapter(listHeroAdapter);
    }

    private void setting_search(){
        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {

            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString(), true, null, true);
            }

            @Override
            public void onButtonClicked(int buttonCode) {
                if (buttonCode == MaterialSearchBar.BUTTON_NAVIGATION) {
                    //opening or closing a navigation drawer
                } else if (buttonCode == MaterialSearchBar.BUTTON_BACK) {
                    materialSearchBar.disableSearch();
                }
            }
        });

        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //proses check di list-nya
                String search = materialSearchBar.getText();

                if (TextUtils.isEmpty(search)) {
                    //hapus dulu list yan ada
                    list.clear();

                    //tampilkan listnya semua data
                    list.addAll(MobilData.getListData());
                    showRecyclerList();
                }
                else {
                    //hapus dulu list yan ada
                    list.clear();

                    //tampilkan listnya
                    list.addAll(MobilData.getFilterText(search));
                    showRecyclerList();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });

        materialSearchBar.setSuggestionsClickListener(new SuggestionsAdapter.OnItemViewClickListener() {
            @Override
            public void OnItemClickListener(int position, View v) {
                //
            }

            @Override
            public void OnItemDeleteListener(int position, View v) {
                //
            }

        });
    }

    public void addDotsIndicator(int position){
        mDotLayout.removeAllViews();
        mDosts = new TextView[5];

        for(int i=0; i< mDosts.length; i++){
            mDosts[i] = new TextView(this);
            mDosts[i].setText(Html.fromHtml("&#8226;",0));
            mDosts[i].setTextSize(35);
            mDosts[i].setTextColor(ContextCompat.getColor(this, R.color.colorSolidGrey));

            mDotLayout.addView(mDosts[i]);
        }

        mDosts[position].setTextColor(ContextCompat.getColor(this, R.color.colorDonker));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
            //
        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            nCurrentPage = i;

        }

        @Override
        public void onPageScrollStateChanged(int i) {
            //
        }
    };

}
