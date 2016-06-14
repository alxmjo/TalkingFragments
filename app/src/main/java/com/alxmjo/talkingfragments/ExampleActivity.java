package com.alxmjo.talkingfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        // FragmentManager is the interface that allows an Activity to interact with fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Look through existing fragments by container view ID and return null if not found
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        // The fragment doesn't exist yet, so create it
        if (fragment == null) {
            fragment = new ExampleFragmentA();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
