package com.example.mobileblogmvp.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobileblogmvp.Models.Project;
import com.example.mobileblogmvp.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.MyViewHolder>{
    private Context context;
    private List<Project> projects;

    public MainAdapter(List<Project> projects, Context context) {
        this.context = context;
        this.projects = projects;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_main_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.nameText.setText(projects.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = (TextView) itemView.findViewById(R.id.textName);

        }
    }




}
