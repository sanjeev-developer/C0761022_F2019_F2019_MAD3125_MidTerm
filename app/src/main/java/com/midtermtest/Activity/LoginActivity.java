package com.midtermtest.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.midtermtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.but_login)
    Button but_login;

    @BindView(R.id.login_email)
    EditText login_email;

    @BindView(R.id.login_password)
    EditText login_password;

    String adminUsername = "Admin";
    String adminPassword = "123456";
    Dialog dialog;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        but_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.but_login:

                if(login_email.getText().toString().equals(""))
                {
                    displayAlert( LoginActivity.this, "Please enter username");
                }
                else if(login_password.getText().toString().equals(""))
                {
                    displayAlert(LoginActivity.this,"Please enter password");
                }
                else
                {
                    if(login_email.getText().toString().equals(adminUsername) && login_password.getText().toString().equals(adminPassword))
                    {
                        intent = new Intent(LoginActivity.this, Dashboard.class);
                        startActivity(intent);
                    }
                    else
                    {
                        displayAlert(LoginActivity.this,"Please check the Username or password");
                    }
                }
                break;
        }
    }

    public  void displayAlert(Context mContext, String strMessage) {
        //dialog intialization
        dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.alert_diag);

        LinearLayout okplaced = (LinearLayout) dialog.findViewById(R.id.ll_alert_ok);
        TextView alertext= (TextView) dialog.findViewById(R.id.text_alert);
        alertext.setText(strMessage);

        okplaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finishAffinity();
    }
}
