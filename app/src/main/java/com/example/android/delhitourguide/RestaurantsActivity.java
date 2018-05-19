package com.example.android.delhitourguide;

import android.app.Activity;
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

public class RestaurantsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(this);
        final ArrayList<Tour> items = new ArrayList<Tour>();
        items.add(new Tour(R.drawable.restaurant1, getString(R.string.restaurant1), getString(R.string.restaurant1_description)));
        items.add(new Tour(R.drawable.restaurant2, getString(R.string.restaurant2), getString(R.string.restaurant2_description)));
        items.add(new Tour(R.drawable.restaurant3, getString(R.string.restaurant3), getString(R.string.restaurant3_description)));
        items.add(new Tour(R.drawable.restaurant4, getString(R.string.restaurant4), getString(R.string.restaurant4_description)));
        items.add(new Tour(R.drawable.restaurant5, getString(R.string.restaurant5), getString(R.string.restaurant5_description)));
        items.add(new Tour(R.drawable.restaurant6, getString(R.string.restaurant6), getString(R.string.restaurant6_description)));
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
            Intent numbersIntent = new Intent(RestaurantsActivity.this, MainActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item2) {
            Intent numbersIntent = new Intent(RestaurantsActivity.this, RestaurantsActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item3) {
            Intent numbersIntent = new Intent(RestaurantsActivity.this, HotelsActivity.class);
            startActivity(numbersIntent);
        }
        if (id == R.id.nav_item4) {
            Intent numbersIntent = new Intent(RestaurantsActivity.this, FestivalsActivity.class);
            startActivity(numbersIntent);
        }
        return true;
    }
}
