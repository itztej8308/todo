package com.example.smarttodo;

public class addDataModel {
    private String task, Date,taskType;

    public addDataModel(){

    }

    public addDataModel(String task, String date, String taskType) {
        this.task = task;
        Date = date;
        this.taskType = taskType;
    }



    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
