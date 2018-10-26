package com.example.fdc_neil.stylishgrabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fdc_neil.stylishgrabs.ADAPTERS.ItemsAdapter;
import com.example.fdc_neil.stylishgrabs.ADAPTERS.ViewPagerAdapter;
import com.example.fdc_neil.stylishgrabs.MODELS.Items;
import com.example.fdc_neil.stylishgrabs.USER.ProfileActivity;
import com.michaldrabik.tapbarmenulib.TapBarMenu;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.SliderDots)
    LinearLayout sliderDotspanel;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ArrayList<Items> items = new ArrayList<>();
    private ItemsAdapter itemsAdapter;


    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

    private void itemClick(){
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "AMAZING!!!", Toast.LENGTH_SHORT).show();
            }
        });
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
                Log.i("TAG", "Item 2 selected");
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
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
