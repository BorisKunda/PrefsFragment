package com.example.jbt.prefsfragment;

import android.content.SharedPreferences;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     getFragmentManager().beginTransaction().add(R.id.mainLayout, new ListFragment()).commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main, menu);
         return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.showList)
        {
            getFragmentManager().beginTransaction().addToBackStack("replacing")
                    .replace(R.id.mainLayout, new ListFragment()).commit();
        }
        else
        {
            getFragmentManager().beginTransaction().addToBackStack("replacing")
                    .replace(R.id.mainLayout, new MyPerfsFragment()).commit();
        }

        return  true;
    }
}
