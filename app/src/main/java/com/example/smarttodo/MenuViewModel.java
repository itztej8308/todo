package com.example.smarttodo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MenuViewModel extends ViewModel {

    private final Repository repository = new Repository();

    // 🔹 Get all items (optional)
    public LiveData<List<addDataModel>> getAllItems() {
        return repository.getMenuItems();
    }

    // 🔹 Get tasks by type (e.g. "today", "weekly")
    public LiveData<List<addDataModel>> getTasksByType(String type) {
        return repository.getTasksByType(type);
    }

    // 🔹 Add a task/item
    public void addItem(addDataModel item) {
        repository.addMenuItem(item);
    }

    // 🔹 Delete a task/item
    public void deleteItem(String documentId) {
        repository.deleteMenuItem(documentId);
    }
}
