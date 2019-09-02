package com.path_studio.reviewcar.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.path_studio.reviewcar.R;
import com.path_studio.reviewcar.fragments.AboutFragment;
import com.path_studio.reviewcar.fragments.HomeFragment;
import com.path_studio.reviewcar.fragments.PhotosFragment;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //membuat bottom nav
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Create fragment transaction
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()){
                    case R.id.action_home :
                        //menuju fragment home
                        transaction.replace(R.id.fragment_container, new HomeFragment());
                        transaction.addToBackStack(null);

                        // Commit the transaction
                        transaction.commit();
                        break;
                    case R.id.action_photos :
                        //menuju fragment photos
                        transaction.replace(R.id.fragment_container, new PhotosFragment());
                        transaction.addToBackStack(null);

                        // Commit the transaction
                        transaction.commit();
                        break;
                    case R.id.action_about :
                        //menuju fragment about
                        transaction.replace(R.id.fragment_container, new AboutFragment());
                        transaction.addToBackStack(null);

                        // Commit the transaction
                        transaction.commit();
                        break;
                }

                return true;
            }
        });

        //panggil fragment home
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }

}
