package com.midtermtest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.midtermtest.Model.Data;
import com.midtermtest.R;

        public class DashAdapter extends RecyclerView.Adapter<DashAdapter.MyViewHolder>
        {
            private Context context;
            Data data;

            public DashAdapter(Context contexts, Data data)
            {
                this.context = contexts;
                this.data= data;
            }

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashlayout, parent, false);
                return new MyViewHolder(itemView);
            }

            @Override
            public void onBindViewHolder(final MyViewHolder holder, final int position)
            {
                holder.title.setText(data.getJsondata().get(position).getName());
                holder.age.setText(data.getJsondata().get(position).getAge().toString());
                holder.company.setText(data.getJsondata().get(position).getVehicle().getMake().toString());
                holder.model.setText(data.getJsondata().get(position).getVehicle().getModel().toString());
                holder.year.setText(data.getJsondata().get(position).getVehicle().getYear().toString());

                if(data.getJsondata().get(position).getVehicle() == null)
                {
                    holder.vstatus.setText("No");
                }
                else
                {
                    holder.vstatus.setText("Yes");
                }
            }

            @Override
            public int getItemCount() {
                return data.getJsondata().size();
            }

            public class MyViewHolder extends RecyclerView.ViewHolder {

                TextView title, age, company, model, year, vstatus;

                public MyViewHolder(View view) {
                    super(view);

                    title=(TextView)view.findViewById(R.id.text_name);
                    age=(TextView)view.findViewById(R.id.text_age);
                    company=(TextView)view.findViewById(R.id.text_vcompany);
                    model=(TextView)view.findViewById(R.id.text_vmodel);
                    year=(TextView)view.findViewById(R.id.text_vyear);
                    vstatus=(TextView)view.findViewById(R.id.txt_vstatus);
                }
            }
        }