package com.example.smarttodo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class HomeTodo extends Fragment {


    public HomeTodo() {
        // Required empty public constructor
    }


    LinearLayout todaytask,weeklytask;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_todo, container, false);

        todaytask = view.findViewById(R.id.todaystaskfrag);
        weeklytask = view.findViewById(R.id.weeklytaskfrag);

        // Optional: Add click listeners here
        todaytask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new Today_task());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        weeklytask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new weekly_task());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view; // return after all logic
    }



}