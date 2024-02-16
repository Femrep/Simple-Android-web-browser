package com.example.hw2_0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPageAdapter viewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.myViewPager);
        viewPageAdapter = new ViewPageAdapter(this);
        viewPager2.setAdapter(viewPageAdapter);


        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText("Tab " + (position + 1))
        ).attach();

        Button searchButton = findViewById(R.id.mySearchButton);
        Button newTabButton = findViewById(R.id.newTab);
        EditText addressText = findViewById(R.id.addrText);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = addressText.getText().toString();
                if (!url.startsWith("http://") && !url.startsWith("https://")&& !url.endsWith(".com")) {
                    url = "https://" + url+ ".com";
                }

                // Load the URL into the current tab
                Tabs currentFragment = (Tabs) getSupportFragmentManager().findFragmentByTag("f" + viewPager2.getCurrentItem());
                if (currentFragment != null) {
                    currentFragment.loadUrl(url, currentFragment.getWebView());
                }
            }
        });


        newTabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a new tab
                viewPageAdapter.addTab("about:blank");
                viewPager2.setCurrentItem(viewPageAdapter.getItemCount() - 1);

                // Add a new tab to the TabLayout
                TabLayout.Tab newTab = tabLayout.newTab();
                tabLayout.addTab(newTab);
                // Ensure the new tab is selected
                tabLayout.selectTab(newTab);
            }
        });
    }
}
