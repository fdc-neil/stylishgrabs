package com.example.fdc_neil.stylishgrabs;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fdc_neil.stylishgrabs.ADAPTERS.ItemsAdapter;
import com.example.fdc_neil.stylishgrabs.ADAPTERS.ViewPagerAdapter;
import com.example.fdc_neil.stylishgrabs.MODELS.Items;
import com.example.fdc_neil.stylishgrabs.USER.ProfileActivity;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.michaldrabik.tapbarmenulib.TapBarMenu;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity /*implements OnMapReadyCallback*/ {

    @BindView(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.SliderDots)
    LinearLayout sliderDotspanel;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.mapView)
    MapView mapView;

    private ArrayList<Items> items = new ArrayList<>();
    private ItemsAdapter itemsAdapter;

    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                // One way to add a marker view
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(10.4819,124.0182))
                        .title("stylishgrabsph")
                        .snippet("Clothings")
                );
            }
        });


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        itemsAdapter = new ItemsAdapter(items, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemsAdapter);

        prepareItemsData();

//      setViewPager();
    }


    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    private void prepareItemsData() {
        Items item = new Items(R.drawable.pirate_shirt, getString(R.string.stripeshirts));
        items.add(item);

        Items item1 = new Items(R.drawable.polo, getString(R.string.polo));
        items.add(item1);

        Items item2 = new Items(R.drawable.shorts, getString(R.string.sweatshorts));
        items.add(item2);

        Items item3 = new Items(R.drawable.trouser, getString(R.string.joggerpants));
        items.add(item3);

        Items item4 = new Items(R.drawable.trousers, getString(R.string.trousers));
        items.add(item4);

        itemsAdapter.notifyDataSetChanged();
    }


    private void setViewPager(){

        for (int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @OnClick(R.id.tapBarMenu)
    void clickTapBarMenu() {
        tapBarMenu.toggle();
    }

    @OnClick({R.id.cartMenu, R.id.infoMenu, R.id.profileMenu})
    public void onMenuItemClick(View view) {
        tapBarMenu.close();
        switch (view.getId()) {
            case R.id.cartMenu:
                startActivity(new Intent(MainActivity.this, ShopActivity.class));
                break;
            case R.id.infoMenu:
                startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                break;
            case R.id.profileMenu:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;
        }
    }
}
