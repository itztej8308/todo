package com.example.smarttodo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.*;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final FirebaseFirestore db;
    private final CollectionReference taskRef;

    public TaskRepository() {
        db = FirebaseFirestore.getInstance();
        taskRef = db.collection("MenuItems"); // Or "tasks", depending on your DB
    }

    public LiveData<List<addDataModel>> getTasksByType(String taskType) {
        MutableLiveData<List<addDataModel>> taskLiveData = new MutableLiveData<>();

        taskRef.whereEqualTo("type", taskType)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<addDataModel> tasks = new ArrayList<>();
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        addDataModel task = doc.toObject(addDataModel.class);
                        tasks.add(task);
                    }
                    taskLiveData.setValue(tasks);
                })
                .addOnFailureListener(e -> {
                    Log.e("TaskRepository", "Failed to fetch tasks", e);
                    taskLiveData.setValue(null);
                });

        return taskLiveData;
    }
}
