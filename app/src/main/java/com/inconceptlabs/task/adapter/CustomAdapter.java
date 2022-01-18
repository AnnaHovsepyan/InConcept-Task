package com.inconceptlabs.task.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inconceptlabs.task.R;
import com.inconceptlabs.task.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<Person> Items = new ArrayList<>();

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(Items.get(position));
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final TextView ageTextView;
        public  CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);
        }

        public void bind(Person person) {
            nameTextView.setText(person.getName());
            ageTextView.setText(person.getAgeByString());
        }
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public void setItems(List<Person> items) {
        this.Items.clear();
        this.Items = items;
        notifyDataSetChanged();
    }
}
