package com.example.android.delhitourguide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(this);
        final ArrayList<Tour> items = new ArrayList<Tour>();
        items.add(new Tour(R.drawable.place1, getString(R.string.place1), getString(R.string.place1_description)));
        items.add(new Tour(R.drawable.place2, getString(R.string.place2), getString(R.string.place2_description)));
        items.add(new Tour(R.drawable.place3, getString(R.string.place3), getString(R.string.place3_description)));
        items.add(new Tour(R.drawable.place4, getString(R.string.place4), getString(R.string.place4_description)));
        items.add(new Tour(R.drawable.place5, getString(R.string.place5), getString(R.string.place5_description)));
        items.add(new Tour(R.drawable.place6, getString(R.string.place6), getString(R.string.place6_description)));
        TourAdapter adapter = new TourAdapter(this, items);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_item1) {
            Intent numbersIntent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item2) {
            Intent numbersIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item3) {
            Intent numbersIntent = new Intent(MainActivity.this, HotelsActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item4) {
            Intent numbersIntent = new Intent(MainActivity.this, FestivalsActivity.class);
            startActivity(numbersIntent);
        }
        return true;
    }
}
