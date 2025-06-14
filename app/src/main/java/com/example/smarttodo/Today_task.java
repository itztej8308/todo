package com.example.smarttodo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Today_task extends Fragment {


    RecyclerView recyclerView;
    TodoAdapter todayAdapter;
    List<addDataModel> tasklist;
    MenuViewModel menuViewModel;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today_task, container, false);


        recyclerView = view.findViewById(R.id.recycleviewtoday);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        todayAdapter = new TodoAdapter();
        recyclerView.setAdapter(todayAdapter);

        // Setup ViewModel
        menuViewModel = new     ViewModelProvider(this).get(MenuViewModel.class);

        // Fetch today's tasks
        observeTodayTasks();




        return view;
    }


    private void observeTodayTasks() {
        menuViewModel.getTasksByType("today").observe(getViewLifecycleOwner(), tasks -> {
            Log.d("TODAY_TASK", "Tasks received: " + tasks.size());
            todayAdapter.setData(tasks);
        });

    }




}