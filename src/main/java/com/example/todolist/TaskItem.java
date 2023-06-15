package com.example.todolist;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class TaskItem {
    private SimpleBooleanProperty status;
    private SimpleStringProperty task;
    private SimpleStringProperty deadline;

    public TaskItem(boolean status, String task, String deadline) {
        this.status = new SimpleBooleanProperty(status);
        this.task = new SimpleStringProperty(task);
        this.deadline = new SimpleStringProperty(deadline);
    }

    public boolean getStatus() { return this.status.get(); }
    public void setStatus(boolean status) { this.status.set(status); }
    public String getTask() {return this.task.get(); }
    public void setTask(String tas) { this.task.set(tas); }
    public String getDeadline() {return this.deadline.get(); }
    public void setDeadline(String deadline) { this.deadline.set(deadline); }
}
