package com.example.smarttodo;

public class tododata {
    String task;
    boolean checkbox;
    String date;
    String tasktype;

    public tododata(String task, boolean checkbox) {
        this.task = task;
        this.checkbox = checkbox;


    }





    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }
}
