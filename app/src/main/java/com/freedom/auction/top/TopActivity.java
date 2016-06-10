package com.freedom.auction.top;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.freedom.auction.R;
import com.freedom.auction.model.item.RemoteItemDataSource;
import com.freedom.auction.util.ActivityUtils;

public class TopActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private TopFragment topFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_top);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        // Set up the drawer toggle
        mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_top);
        // Tie DrawerLayout events to the ActionBarDrawerToggle
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        // Set up the floating action button
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_top);
        if (floatingActionButton != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }
            });
        }

        // Set up the Navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_top);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        topFragment = (TopFragment) getSupportFragmentManager().findFragmentById(R.id.frame_top);
        if (topFragment == null) {
            topFragment = TopFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), topFragment, R.id.frame_top);
        }

        new TopPresenter(RemoteItemDataSource.getInstance(), topFragment);

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.nav_menu_home:
                                break;
                            case R.id.nav_menu_news:
                                break;
                            case R.id.nav_menu_favorites:
                                break;
                            case R.id.nav_menu_sold_listings:
                                break;
                            case R.id.nav_menu_purchased_listings:
                                break;
                            case R.id.nav_menu_settings:
                                break;
                            case R.id.nav_menu_guide:
                                break;
                            default:
                                break;
                        }

                        mDrawerLayout.closeDrawer(GravityCompat.START);

                        return true;
                    }
                });
    }

}
