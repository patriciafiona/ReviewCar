package com.path_studio.reviewcar.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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


public class HomeFragment extends Fragment implements View.OnClickListener{

    private RecyclerView rvCars;
    private ArrayList<Mobil> list = new ArrayList<>();

    private MaterialSearchBar materialSearchBar;

    private com.path_studio.reviewcar.Adapter.slider_adapter slider_adapter;
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDosts;
    private int nCurrentPage;

    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //untuk view slider
        mSlideViewPager = (ViewPager) view.findViewById(R.id.carSlider);
        mDotLayout = (LinearLayout) view.findViewById(R.id.dotsLayoutPromotion);

        slider_adapter = new slider_adapter(getActivity());
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
        materialSearchBar = view.findViewById(R.id.searchBar);
        setting_search();


        rvCars = view.findViewById(R.id.rv_cars);
        rvCars.setHasFixedSize(true);

        list.addAll(MobilData.getListData());
        showRecyclerList();

    }

    @Override
    public void onClick(View view) {
        //
    }

    public void go_to_detail(ArrayList list){
        //direct ke halaman detail mobil

        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        //menuju fragment detail mobil
        ft.replace(R.id.fragment_container, new DetailMobilFragment(), "Got to Detail");
        ft.commit();

        //tampilkan data ui-nya
        DetailMobilFragment detailMobilFragment = new DetailMobilFragment();
        detailMobilFragment.UI(list);

    }

    private void showRecyclerList(){
        rvCars.setLayoutManager(new LinearLayoutManager(getActivity()));
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
                //startSearch(text.toString(), true, null, true);
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
            mDosts[i] = new TextView(getActivity());
            mDosts[i].setText(Html.fromHtml("&#8226;",0));
            mDosts[i].setTextSize(35);
            mDosts[i].setTextColor(ContextCompat.getColor(getActivity(), R.color.colorSolidGrey));

            mDotLayout.addView(mDosts[i]);
        }

        mDosts[position].setTextColor(ContextCompat.getColor(getActivity(), R.color.colorDonker));

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
