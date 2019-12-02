package com.midtermtest.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.midtermtest.Adapter.DashAdapter;
import com.midtermtest.ApiClient.ApiClient;
import com.midtermtest.ApiInterface.ApiInterface;
import com.midtermtest.Model.Data;
import com.midtermtest.R;
import retrofit2.Call;
import retrofit2.Callback;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    ApiInterface apiInterface;
    public Dialog dialog;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    DashAdapter dashAdapter;
    ImageView img_back_dash;
    Dialog Alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.rec_dash);
        img_back_dash = findViewById(R.id.img_back_dash);
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        img_back_dash.setOnClickListener(this);
        apihit();
    }

    private void apihit() {

        displaydialog("Loading please wait....");
        Call<Data> call = apiInterface.fetchdata();
        call.enqueue(new Callback<Data>() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<Data> call, retrofit2.Response<Data> response) {

                dialog.cancel();
                

                else
                    {

                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                dialog.cancel();
                call.cancel();
            }

        });
    }

    public  void displaydialog( String strMessage)
    {
        dialog = new Dialog(Dashboard.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Dashboard.this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(Dashboard.this, R.color.transparent)));
        dialog.setContentView(R.layout.loadinglayout);
        dialog.setCancelable(true);

        TextView message= dialog.findViewById(R.id.txt_loading);
        message.setText(strMessage);

        if (dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
        else
        {
            dialog.show();
        }
    }

    @Override
    public void onClick(View view) {

        displayAlert();
    }

    public  void displayAlert() {

        //dialog intialization
        Alert = new Dialog(Dashboard.this);
        Alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Alert.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(Dashboard.this, R.color.comp_trans)));
        Alert.setContentView(R.layout.logout_weird);

        LinearLayout ok = (LinearLayout) Alert.findViewById(R.id.ll_alert_ok);
        LinearLayout logout = (LinearLayout) Alert.findViewById(R.id.ll_alert_logout);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Alert.cancel();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Dashboard.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        Alert.show();
    }
}
