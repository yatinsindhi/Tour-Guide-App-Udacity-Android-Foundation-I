package com.example.android.delhitourguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class FestivalsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festivals);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(this);
        final ArrayList<Tour> items = new ArrayList<Tour>();
        items.add(new Tour(R.drawable.festival1, getString(R.string.festival1), getString(R.string.festival1_description)));
        items.add(new Tour(R.drawable.festival2, getString(R.string.festival2), getString(R.string.festival2_description)));
        items.add(new Tour(R.drawable.festival3, getString(R.string.festival3), getString(R.string.festival3_description)));
        items.add(new Tour(R.drawable.festival4, getString(R.string.festival4), getString(R.string.festival4_description)));
        items.add(new Tour(R.drawable.festival5, getString(R.string.festival5), getString(R.string.festival5_description)));
        items.add(new Tour(R.drawable.festival6, getString(R.string.festival6), getString(R.string.festival6_description)));
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
            Intent numbersIntent = new Intent(FestivalsActivity.this, MainActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item2) {
            Intent numbersIntent = new Intent(FestivalsActivity.this, RestaurantsActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item3) {
            Intent numbersIntent = new Intent(FestivalsActivity.this, HotelsActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item4) {
            Intent numbersIntent = new Intent(FestivalsActivity.this, FestivalsActivity.class);
            startActivity(numbersIntent);
        }
        return true;
    }
}
