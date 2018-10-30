package com.example.fdc_neil.stylishgrabs.USER;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.fdc_neil.stylishgrabs.MainActivity;
import com.example.fdc_neil.stylishgrabs.R;
import com.example.fdc_neil.stylishgrabs.UTILITIES.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.refactor.lib.colordialog.PromptDialog;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private FirebaseAuth mAuth;
    String textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initFirebase();
        progressBar.setVisibility(View.GONE);
    }

    private void initFields(){
         textEmail = etEmail.getText().toString();
         textPassword = etPassword.getText().toString();
    }

    private void initFirebase(){
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        startActivity(new Intent(LoginActivity.this, MainActivity.class));

    }

    private void userSignin(){
        mAuth.signInWithEmailAndPassword(textEmail, textPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(Constants.LOGIN_SUCCESS, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(Constants.LOGIN_FAILED, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }

                        // ...
                    }
                });
    }

    @OnClick(R.id.tvClickHere)
    void createAccount(){
        startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));
    }

    @OnClick(R.id.btnSubmit)
    void login(){
        btnSubmit.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        initFields();

       /* if (TextUtils.isEmpty(textEmail) || TextUtils.isEmpty(textPassword)){
            new PromptDialog(this)
                    .setDialogType(PromptDialog.DIALOG_TYPE_WRONG)
                    .setAnimationEnable(true)
                    .setTitleText(getString(R.string.loginFailedTitle))
                    .setContentText(getString(R.string.loginFieldsEmpty))
                    .setPositiveListener(getString(R.string.ok), new PromptDialog.OnPositiveListener() {
                        @Override
                        public void onClick(PromptDialog dialog) {
                            dialog.dismiss();
                        }
                    }).show();
            progressBar.setVisibility(View.GONE);

        }else {
            userSignin();
        }*/
        finish();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
