package com.example.smarttodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewholder> {

    List<tododata> todolist;

    public TodoAdapter(List<tododata>tododata){
        this.todolist = tododata;

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

        tododata item = todolist.get(position);
        holder.checkBox.setChecked(item.isCheckbox());
        holder.taskview.setText(item.getTask());



        holder.checkBox.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            item.setCheckbox(isChecked);
        }));


    }

    @Override
    public int getItemCount() {
        return todolist.size();
    }
}
