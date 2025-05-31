package com.example.smarttodo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class HomeFragment extends Fragment {

    ProgressBar progressBar;
    FrameLayout frameLayout;


    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        progressBar = view.findViewById(R.id.taskProgressBar);


        int totalTasks = 10;
        int completedTasks = 5;

        if (totalTasks > 0) {
            int progressPercent = (completedTasks * 100) / totalTasks;
            progressBar.setProgress(progressPercent);
        } else {
            progressBar.setProgress(0);
        }

        return view;
    }
}
