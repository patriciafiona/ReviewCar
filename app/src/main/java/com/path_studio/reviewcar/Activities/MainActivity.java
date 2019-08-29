package com.path_studio.reviewcar.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.mancj.materialsearchbar.MaterialSearchBar;
import com.mancj.materialsearchbar.adapter.SuggestionsAdapter;
import com.path_studio.reviewcar.Adapter.ListMobilAdapter;
import com.path_studio.reviewcar.Models.Mobil;
import com.path_studio.reviewcar.Models.MobilData;
import com.path_studio.reviewcar.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCars;
    private ArrayList<Mobil> list = new ArrayList<>();

    private MaterialSearchBar materialSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting search bar
        materialSearchBar = findViewById(R.id.searchBar);
        setting_search();


        rvCars = findViewById(R.id.rv_cars);
        rvCars.setHasFixedSize(true);

        list.addAll(MobilData.getListData());
        showRecyclerList();

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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //
            }

            @Override
            public void afterTextChanged(Editable s) {

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

}
