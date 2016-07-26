package com.freedom.auction.top;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.freedom.auction.R;
import com.freedom.auction.model.item.RemoteItemDataSource;
import com.freedom.auction.model.news.RemoteNewsDataSource;
import com.freedom.auction.news.NewsFragment;
import com.freedom.auction.news.NewsPresenter;
import com.freedom.auction.util.ActivityUtils;

public class TopActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private DrawerLayout mDrawerLayout;

    private TopFragment mTopFragment;

    private TopPresenter mTopPresenter;

    private NewsFragment mNewsFragment;

    private NewsPresenter mNewsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_top);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout_top);

        // Set up the drawer toggle
        mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_top);
        // Tie DrawerLayout events to the ActionBarDrawerToggle
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // Set up the floating action button
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_top);
        if (floatingActionButton != null) {
            setupFloatingButtonOnClickListener(floatingActionButton);
        }

        // Set up the Navigation
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_top);
        if (navigationView != null) {
            setNavigationItemSelectedListener(navigationView);
        }

        if (mTopFragment == null) {
            mTopFragment = TopFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mTopFragment, R.id.frame_top);
        } else {
            ActivityUtils.replaceFragment(getSupportFragmentManager(), mTopFragment, R.id.frame_top);
        }

        if (mTopPresenter == null) {
            mTopPresenter = new TopPresenter(RemoteItemDataSource.getInstance(), mTopFragment);
        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_bar_menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_search_top:
                // TODO
                break;
            case R.id.action_notification_top:
                // TODO
                break;
            case R.id.action_done_top:
                // TODO
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupFloatingButtonOnClickListener(FloatingActionButton floatingActionButton) {
        // TODO Start Camera
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

    private void setNavigationItemSelectedListener(NavigationView navigationView) {
        // Handle navigation view item clicks here.
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.nav_menu_home:
                                if (mTopFragment == null) {
                                    mTopFragment = TopFragment.newInstance();
                                }
                                ActivityUtils.replaceFragment(getSupportFragmentManager(), mTopFragment, R.id.frame_top);
                                if (mTopPresenter == null) {
                                    mTopPresenter = new TopPresenter(RemoteItemDataSource.getInstance(), mTopFragment);
                                }
                                break;
                            case R.id.nav_menu_news:
                                if (mNewsFragment == null) {
                                    mNewsFragment = NewsFragment.newInstance();
                                }
                                ActivityUtils.replaceFragment(getSupportFragmentManager(), mNewsFragment, R.id.frame_top);
                                if (mNewsPresenter == null) {
                                    mNewsPresenter = new NewsPresenter(RemoteNewsDataSource.getInstance(), mNewsFragment);
                                }
                                break;
                            case R.id.nav_menu_favorites:
                                // TODO
                                break;
                            case R.id.nav_menu_sold_listings:
                                // TODO
                                break;
                            case R.id.nav_menu_purchased_listings:
                                // TODO
                                break;
                            case R.id.nav_menu_settings:
                                // TODO
                                break;
                            case R.id.nav_menu_guide:
                                // TODO
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
