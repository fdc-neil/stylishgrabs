package com.example.fdc_neil.stylishgrabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.michaldrabik.tapbarmenulib.TapBarMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tapBarMenu)
    void clickTapBarMenu() {
        tapBarMenu.toggle();
    }

    @OnClick({R.id.homeMenu, R.id.cartMenu, R.id.phoneMenu, R.id.resumeMenu})
    public void onMenuItemClick(View view) {
        tapBarMenu.close();
        switch (view.getId()) {
            case R.id.homeMenu:
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                break;
            case R.id.cartMenu:
                Log.i("TAG", "Item 2 selected");
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.phoneMenu:
                Log.i("TAG", "Item 3 selected");
                Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.resumeMenu:
                Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
