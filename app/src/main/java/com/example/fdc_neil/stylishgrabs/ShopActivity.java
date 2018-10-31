package com.example.fdc_neil.stylishgrabs;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.fdc_neil.stylishgrabs.FRAGMENTS.StripedShirtFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopActivity extends FragmentActivity {

    @BindView(R.id.rlCartItems)
    RelativeLayout rlCarlItems;

    @BindView(R.id.ibBack)
    ImageButton ibBack;
   /* @BindView(R.id.pager)
    ViewPager pager;
*/
    @BindView(R.id.svSearchView)
    android.support.v7.widget.SearchView searchView;

    private FragmentManager toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);
//        searchView.setQueryHint("Search here...");
        toolbar = getSupportFragmentManager();
//        loadFragment(new StoreFragment());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.striped_shirt:
                    return true;
                case R.id.polo:
                    Fragment fragment = new StripedShirtFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();
                    return true;
                case R.id.sweat_shorts:
                    return true;
                case R.id.jogger_pants:
                    return true;
                case R.id.trouser:
                    return true;
            }
            return false;
        }
    };

    @OnClick({R.id.rlCartItems, R.id.ibCart, R.id.svSearchView, R.id.ibBack})
    public void OnMenuItemClick(View view){
        switch (view.getId()){
            case R.id.svSearchView:
                Toast.makeText(this, "CONGRATS!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ibCart:
                Log.d("AMAZING", "Cart is Clicked");
                Toast.makeText(this, "Cart is clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ibBack:
                super.onBackPressed();
                finish();
                break;
        }
    }
}
