package com.example.smarttodo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    TodoAdapter todoAdapter;
    List<tododata> tasklist;





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
        tasklist = new ArrayList<>();

        tasklist.add( new tododata("buy milk", false));
        tasklist.add(new tododata("code to App", false));


        todoAdapter = new TodoAdapter(tasklist);
        recyclerView.setAdapter(todoAdapter);





        return view;
    }



}