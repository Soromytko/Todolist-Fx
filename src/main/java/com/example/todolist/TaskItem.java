package com.example.todolist;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class TaskItem {
    private CheckBox status;
    private SimpleStringProperty task;
    private SimpleStringProperty deadline;

    public TaskItem(CheckBox status, String task, String deadline) {
        this.status = status;
        this.task = new SimpleStringProperty(task);
        this.deadline = new SimpleStringProperty(deadline);
    }

    public CheckBox getStatus() { return this.status; }
    public void setStatus(CheckBox status) { this.status = status; }
    public String getTask() {return this.task.get(); }
    public void setTask(String tas) { this.task.set(tas); }
    public String getDeadline() {return this.deadline.get(); }
    public void setDeadline(String deadline) { this.deadline.set(deadline); }
}
