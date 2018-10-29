package com.example.fdc_neil.stylishgrabs.USER;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fdc_neil.stylishgrabs.MainActivity;
import com.example.fdc_neil.stylishgrabs.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tvClickHere)
    void createAccount(){
        startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));
    }

    @OnClick(R.id.btnSubmit)
    void login(){
        finish();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
