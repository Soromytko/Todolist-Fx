package com.example.todolist;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.time.LocalDate;

public class TaskItem {
    private CheckBox status;
    private SimpleStringProperty task;
    private LocalDate deadline;

    public TaskItem(CheckBox status, String task, LocalDate deadline) {
        this.status = status;
        this.task = new SimpleStringProperty(task);
        this.deadline = deadline;
    }

    public CheckBox getStatus() { return this.status; }
    public void setStatus(CheckBox status) { this.status = status; }
    public String getTask() {return this.task.get(); }
    public void setTask(String tas) { this.task.set(tas); }
    public LocalDate getDeadline() {return this.deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
}
