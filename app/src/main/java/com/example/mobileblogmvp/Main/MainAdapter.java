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

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.MyViewHolder>{

    private List<Project> projects = new ArrayList<>();
    private Context context;

    public MainAdapter(Context context) {
        this.context = context;

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

    public void setItems(List<Project> projects){
        this.projects.clear();
        this.projects.addAll(projects);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.textName);
        }

    }
}
