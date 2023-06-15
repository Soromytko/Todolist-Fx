package com.example.todolist;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateTaskController {

    @FXML private TextField name;
    @FXML private TextArea description;
    @FXML private DatePicker deadline;

    @FXML private void onOk(ActionEvent event)
    {
        System.out.println(name.getText());
        System.out.println(description.getText());
        System.out.println(deadline.getValue());

        TaskItem task = new TaskItem(new CheckBox(), name.getText(), deadline.getValue(), description.getText());
        AppData.tasks.add(task);

        WindowLoader.getStage(event).close();
    }

    @FXML private void onCancel(ActionEvent event)
    {
        WindowLoader.getStage(event).close();
    }

}
