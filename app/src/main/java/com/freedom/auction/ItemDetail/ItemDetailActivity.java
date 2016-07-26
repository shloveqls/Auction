package com.freedom.auction.ItemDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.freedom.auction.R;

public class ItemDetailActivity extends AppCompatActivity {

    private ItemDetailFragment mItemDetailFragment;

    private ItemDetailPresenter mItemDetailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_detail);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_item_detail);
        setSupportActionBar(toolbar);

        mItemDetailFragment = (ItemDetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_item_detail);


    }

}
