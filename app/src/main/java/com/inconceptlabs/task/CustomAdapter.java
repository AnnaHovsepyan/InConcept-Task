package com.inconceptlabs.task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private ArrayList<MainActivity.Person> Items;

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ((TextView)  holder.itemView.findViewById(R.id.nameTextView)).setText(Items.get(position).getName());
        ((TextView) holder.itemView.findViewById(R.id.ageTextView)).setText(Items.get(position).getAge().toString());
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public  CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public void setItems(ArrayList<MainActivity.Person> items) {
        this.Items = items;
        notifyDataSetChanged();

    }


}
