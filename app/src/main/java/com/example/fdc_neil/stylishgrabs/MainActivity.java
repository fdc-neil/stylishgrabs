package com.example.fdc_neil.stylishgrabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.michaldrabik.tapbarmenulib.TapBarMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;

    @BindView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.tapBarMenu)
    void clickTapBarMenu() {
        tapBarMenu.toggle();
    }

    @OnClick({R.id.homeMenu, R.id.cartMenu, R.id.phoneMenu, R.id.profileMenu})
    public void onMenuItemClick(View view) {
        tapBarMenu.close();
        switch (view.getId()) {
            case R.id.homeMenu:
                Log.i("TAG", "Item 1 selected");
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cartMenu:
                Log.i("TAG", "Item 2 selected");
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.phoneMenu:
                Log.i("TAG", "Item 3 selected");
                Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profileMenu:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;
        }
    }
}
