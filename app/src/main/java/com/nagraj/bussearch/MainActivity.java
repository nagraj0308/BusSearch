package com.nagraj.bussearch;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    NavigationView navigationView;
    MenuItem first,second,third;
    CompoundButton cbfirst,cbsecond,cbthird;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.nvView);
        mDrawer = findViewById(R.id.drawer_layout);
        // Set a Toolbar to replace the ActionBar.
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        first = navigationView.getMenu().findItem(R.id.sps);
        cbfirst = (CompoundButton) first.getActionView();
        second = navigationView.getMenu().findItem(R.id.kpn);
        cbsecond = (CompoundButton) second.getActionView();
        third = navigationView.getMenu().findItem(R.id.praveen);
        cbthird = (CompoundButton) third.getActionView();


        // Find our drawer view

        drawerToggle = setupDrawerToggle();
        setupDrawerContent(navigationView);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();


        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);


        itemChecked();

    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }
    public void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.sps:
                Toast.makeText(getApplicationContext(),"First",Toast.LENGTH_SHORT).show();
                break;
            case R.id.kpn:
                Toast.makeText(getApplicationContext(),"Second",Toast.LENGTH_SHORT).show();

                break;
            case R.id.praveen:
                Toast.makeText(getApplicationContext(),"Third",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(),"Default",Toast.LENGTH_SHORT).show();
        }
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        // mDrawer.closeDrawers();
    }
    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public void itemChecked(){
        cbfirst.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Toast.makeText(getApplicationContext(),"I"+b,Toast.LENGTH_SHORT).show();

            }
        });
        cbsecond.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Toast.makeText(getApplicationContext(),"II"+b,Toast.LENGTH_SHORT).show();

            }
        });
        cbthird.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Toast.makeText(getApplicationContext(),"III"+b,Toast.LENGTH_SHORT).show();

            }
        });

    }

}


