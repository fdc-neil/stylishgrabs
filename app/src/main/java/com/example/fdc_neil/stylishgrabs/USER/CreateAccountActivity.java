package com.example.fdc_neil.stylishgrabs.USER;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.fdc_neil.stylishgrabs.MainActivity;
import com.example.fdc_neil.stylishgrabs.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.refactor.lib.colordialog.PromptDialog;

public class CreateAccountActivity extends AppCompatActivity {

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.etFirstname)
    EditText etFirstname;

    @BindView(R.id.etLastname)
    EditText etLastname;

    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        progressBar.setVisibility(View.GONE);

    }
    @OnClick(R.id.btnSubmit)
    void createAccount(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String firstname = etFirstname.getText().toString();
        String lastname = etLastname.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(firstname) || TextUtils.isEmpty(lastname)){
            new PromptDialog(this)
                    .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                    .setAnimationEnable(true)
                    .setTitleText(getString(R.string.createaccount_errortitle))
                    .setContentText(getString(R.string.loginFieldsEmpty))
                    .setPositiveListener(getString(R.string.ok), new PromptDialog.OnPositiveListener() {
                        @Override
                        public void onClick(PromptDialog dialog) {
                            dialog.dismiss();
                        }
                    }).show();
        }else{

        }


    }


}
