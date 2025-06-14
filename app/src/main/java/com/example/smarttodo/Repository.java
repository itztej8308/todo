package com.example.smarttodo;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference menuCollection = db.collection("MenuItems");

    private MutableLiveData<List<addDataModel>> menuLiveData = new MutableLiveData<>();

    public MutableLiveData<List<addDataModel>> getMenuItems() {
        fetchMenuItemsFromFirestore();
        return menuLiveData;
    }

    private void fetchMenuItemsFromFirestore() {
        menuCollection.get().addOnCompleteListener(task -> {
            List<addDataModel> menuList = new ArrayList<>();
            if (task.isSuccessful() && task.getResult() != null) {
                for (QueryDocumentSnapshot doc : task.getResult()) {
                    addDataModel item = doc.toObject(addDataModel.class);
                    menuList.add(item);
                }
                menuLiveData.postValue(menuList);
            } else {
                menuLiveData.postValue(null);
            }
        });
    }



    public void deleteMenuItem(String documentId) {
        menuCollection.document(documentId).delete();
    }

    public void addMenuItem(addDataModel item) {
        menuCollection.add(item);
    }

    public LiveData<List<addDataModel>> getTasksByType(String type) {
        MutableLiveData<List<addDataModel>> filteredLiveData = new MutableLiveData<>();

        menuCollection
                .whereEqualTo("type", type)
                .get()
                .addOnCompleteListener(task -> {
                    List<addDataModel> filteredList = new ArrayList<>();
                    if (task.isSuccessful() && task.getResult() != null) {
                        for (QueryDocumentSnapshot doc : task.getResult()) {
                            addDataModel item = doc.toObject(addDataModel.class);
                            filteredList.add(item);
                        }
                        filteredLiveData.postValue(filteredList);
                    } else {
                        filteredLiveData.postValue(null);
                    }
                });

        return filteredLiveData;

    }
}
