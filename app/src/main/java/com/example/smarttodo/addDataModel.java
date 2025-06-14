package com.example.smarttodo;

public class addDataModel {
    private String task;
    private String date;
    private String taskType;
    private boolean complete;


    public addDataModel(){

    }

    public addDataModel(String task, String date, String taskType) {
        this.task = task;
        this.date = date;
        this.taskType = taskType;

    }



    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
