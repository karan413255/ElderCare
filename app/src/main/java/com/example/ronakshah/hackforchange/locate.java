package com.example.ronakshah.hackforchange;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class locate extends AppCompatActivity
{
    private WebView wv;
    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        wv = (WebView)findViewById(R.id.webView);
        wv.setWebViewClient(new MyBrowser());

        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.getSettings().setDisplayZoomControls(true);
        wv.loadUrl("https://www.google.co.in/maps/search/hospitals+near+me/@19.1197427,72.8521395,13z");
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.four_button);

        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.four_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.health_item:
                        Intent inr = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(inr);
                        break;
                    case R.id.reminder_item:
                        Intent i = new Intent(getApplicationContext(), ReminderActivity.class);
                        startActivity(i);
                        break;
                    case R.id.location_item:
                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.videos_item: {
                        Intent in = new Intent(getApplicationContext(), Video.class);
                        startActivity(in);
                        break;
                    }
                }
            }
        });

        bottomBar.setActiveTabColor("#C2185B");
    }
    private class MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
