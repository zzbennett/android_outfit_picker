package com.bennett.androidoutfitpicker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

public class MainActivity extends FragmentActivity {

	//checking to see if git is working
	private FragmentTabHost mTabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("outfits").setIndicator("",
                getResources().getDrawable(R.drawable.ic_outfit_tab)),
                OutfitFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("wardrobe").setIndicator("",
                getResources().getDrawable(R.drawable.ic_wardrobe_tab)),
                WardrobeFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("laundry").setIndicator("",
                getResources().getDrawable(R.drawable.ic_laundry_tab)),
                   LaundryFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fashion").setIndicator("",
                getResources().getDrawable(R.drawable.ic_fashion_tab)),
                FashionFragment.class, null);
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
