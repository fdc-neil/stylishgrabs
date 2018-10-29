package com.example.fdc_neil.stylishgrabs;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopActivity extends AppCompatActivity {

    @BindView(R.id.rlCartItems)
    RelativeLayout rlCarlItems;

    @BindView(R.id.pager)
    ViewPager pager;

    @BindView(R.id.svSearchView)
    android.support.v7.widget.SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);
        searchView.setQueryHint("Search here...");
    }


    @OnClick({R.id.rlCartItems, R.id.ibCart, R.id.svSearchView})
    public void OnMenuItemClick(View view){
        switch (view.getId()){
            case R.id.svSearchView:
                Toast.makeText(this, "CONGRATS!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ibCart:
                Log.d("AMAZING", "Cart is Clicked");
                Toast.makeText(this, "Cart is clicked!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
