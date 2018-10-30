package com.example.fdc_neil.stylishgrabs.USER;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fdc_neil.stylishgrabs.AboutUsActivity;
import com.example.fdc_neil.stylishgrabs.MainActivity;
import com.example.fdc_neil.stylishgrabs.R;
import com.michaldrabik.tapbarmenulib.TapBarMenu;
import com.santalu.widget.MaskEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {

    /*@BindView(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;
*/

    @BindView(R.id.tvProfileName)
    TextView tvProfileName;

    @BindView(R.id.tvProfileAddress)
    TextView tvProfileAddress;

    @BindView(R.id.etFullname)
    EditText etFullname;

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPlace)
    EditText etPlace;

    @BindView(R.id.ivUserPhoto)
    ImageView ivUserPhoto;

    @BindView(R.id.etPhoneNumber)
    MaskEditText etPhoneNumber;

    @BindView(R.id.btnEditSave)
    Button btnEditSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        disableFields();
    }

    private void disableFields(){
        etFullname.setEnabled(false);
        etEmail.setEnabled(false);
        etPlace.setEnabled(false);
        etPhoneNumber.setEnabled(false);
        ivUserPhoto.setEnabled(false);
    }

    private void enableFields(){
        etFullname.setEnabled(true);
        etEmail.setEnabled(true);
        etPlace.setEnabled(true);
        etPhoneNumber.setEnabled(true);
        ivUserPhoto.setEnabled(true);
    }

    @OnClick({R.id.ivUserPhoto, R.id.btnEditSave, R.id.btnBackToHome})
    public void onMenuItemClick(View view) {
        switch (view.getId()) {
            case R.id.ivUserPhoto:
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                break;
            case R.id.btnEditSave:
                String editORsave = btnEditSave.getText().toString();
                if (editORsave.equals("Save")){
                    disableFields();
                    btnEditSave.setText("Edit");
                }else{
                    btnEditSave.setText("Save");
                    enableFields();
                }
                break;
            case R.id.btnBackToHome:
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                break;
        }
    }
}
