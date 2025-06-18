package com.example.smarttodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewholder> {

    private List<addDataModel> taskList = new ArrayList<>(); // ✅ Prevent null

    public void setData(List<addDataModel> tasks) {
        if (tasks != null) {
            this.taskList = tasks;
        } else {
            this.taskList = new ArrayList<>();
        }
        notifyDataSetChanged();
    }
    public static class TodoViewholder extends RecyclerView.ViewHolder{

        CheckBox checkBox;
        TextView taskview;

        public TodoViewholder(@NonNull View itemView) {
            super(itemView);
            checkBox =itemView.findViewById(R.id.checkbox);
            taskview = itemView.findViewById(R.id.tasklist);

        }
    }


    @NonNull
    @Override
    public TodoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_list ,parent,false);
        return  new TodoViewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.TodoViewholder holder, int position) {



        addDataModel item = taskList.get(position);
        holder.checkBox.setChecked(item.isComplete());
        holder.taskview.setText(item.getTask());



        holder.checkBox.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            item.setComplete(isChecked);
        }));

    }

    @Override
    public int getItemCount() {
        return taskList != null ? taskList.size() : 0; // ✅ Safe null check
    }
}
