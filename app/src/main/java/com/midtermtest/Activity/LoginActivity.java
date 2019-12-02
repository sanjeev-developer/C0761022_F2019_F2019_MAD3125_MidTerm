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




