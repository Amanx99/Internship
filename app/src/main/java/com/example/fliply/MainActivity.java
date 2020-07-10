package com.example.fliply;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private BottomBar bottomBar;

    Home home = new Home();
    Search_Results_Fliply searchResults = new Search_Results_Fliply();
    Profile profile = new Profile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar = (BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (tabId) {
                    case R.id.tab_home:
                        transaction.replace(R.id.fragment_container, home);
                        transaction.commit();
                        break;
                    case R.id.tab_search:
                        transaction.replace(R.id.fragment_container, searchResults);
                        transaction.commit();
                        break;
                    case R.id.tab_profile:
                        transaction.replace(R.id.fragment_container, profile);
                        transaction.commit();
                        break;
                }
            }
        });
    }
}
