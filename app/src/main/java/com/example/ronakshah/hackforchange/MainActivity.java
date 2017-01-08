package com.example.ronakshah.hackforchange;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Data> data1 = new ArrayList<>();

        data1.add(new Data("Abn boinkmlop","Dr.Trust","01/01/2017"));
        data1.add(new Data("Pqr Xyz","Dr.Inter","22/09/2016"));
        data1.add(new Data("Abn boinkmlop","Dr.Trust","21/06/2016"));
        data1.add(new Data("Abn boinkmlop", "Dr.Trust", "01/11/2015"));
        data1.add(new Data("Abn boinkmlop", "Dr.Trust", "13/01/2016"));


        TextView tv = (TextView)findViewById(R.id.textView);
        String show="";
        for(int i=0;i<data1.size();i++)
        {
            Data d = data1.get(i);
            show=show+d.getPname()+"\t"+d.getDname()+"\t"+d.getDdate()+"\n";
        }

        tv.setText(show);


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8097507416"));
                startActivity(i);
            }
        });

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.four_button);

        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.four_buttons_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.health_item:

                        Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.reminder_item:
                        Intent i = new Intent(getApplicationContext(),ReminderActivity.class);
                        startActivity(i);
                        //Snackbar.make(coordinatorLayout, "Favorite Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.location_item:
                        Intent ing =  new Intent(getApplicationContext(),locate.class);
                        startActivity(ing);
//                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.videos_item: {
                            Intent in =  new Intent(getApplicationContext(),Video.class);
                            startActivity(in);
//                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });

        bottomBar.setActiveTabColor("#C2185B");

        /*Button b = (Button) findViewById(R.id.button);

        assert b != null;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ReminderActivity.class);
                startActivity(intent);
            }
        });
*/
    }


}
