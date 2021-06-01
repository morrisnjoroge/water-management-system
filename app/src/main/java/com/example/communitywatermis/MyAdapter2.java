package com.example.communitywatermis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder>{

    ArrayList<Model2> mList2;
    Context context2;

    public MyAdapter2(Context context2, ArrayList<Model2> mList2){
        this.mList2=mList2;
        this.context2=context2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context2).inflate(R.layout.item2,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model2 model2=mList2.get(position);
        holder.date.setText(model2.getDate());
        holder.area.setText(model2.getArea());
        holder.announcements.setText(model2.getAnnouncements());

    }

    @Override
    public int getItemCount() {
        return mList2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date,area,announcements;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date_text);
            area=itemView.findViewById(R.id.locations_text);
            announcements=itemView.findViewById(R.id.announcements_text);
        }
    }


}
