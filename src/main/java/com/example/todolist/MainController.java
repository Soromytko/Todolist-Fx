package com.example.todolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private TableView table;
    @FXML private  TableColumn statusPrimaryColumn;
    @FXML private  TableColumn taskPrimaryColumn;
    @FXML private  TableColumn deadLinePrimaryColumn;
    @FXML private  TableColumn descriptionPrimaryColumn;

    @FXML private void onCreateNewTask(ActionEvent event) {
        WindowLoader.load("task.fxml");
    }

    @FXML private void onActiveSelect(ActionEvent event) {
        System.out.println("SDSDSD");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AppData.tasks = FXCollections.observableArrayList(
                new TaskItem(new CheckBox(), "Walk the dog", LocalDate.now(), "Take a walk with your dog in the park"),
                new TaskItem(new CheckBox(), "Read the book", LocalDate.now(), "Books by Stephen King"),
                new TaskItem(new CheckBox(), "Work", LocalDate.now(), "Complete the task from the employer")
        );
        table.setItems(AppData.tasks);
        TableColumn<TaskItem, CheckBox> statusColumn = new TableColumn<TaskItem, CheckBox>("Статус");
        TableColumn<TaskItem, String> taskColumn = new TableColumn<TaskItem, String>("Задача");
        TableColumn<TaskItem, LocalDate> deadlineColumn = new TableColumn<TaskItem, LocalDate>("Дедлайн");
        TableColumn<TaskItem, String> descriptionColumn = new TableColumn<TaskItem, String>("Описание");
        statusColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, CheckBox>("status"));
        taskColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, String>("task"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, LocalDate>("deadline"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, String>("description"));
        table.getColumns().set(0, statusColumn);
        table.getColumns().set(1, taskColumn);
        table.getColumns().set(2, deadlineColumn);
        table.getColumns().set(3, descriptionColumn);
        statusColumn.setStyle(statusPrimaryColumn.getStyle());
        taskColumn.setStyle(taskPrimaryColumn.getStyle());
        deadlineColumn.setStyle(deadLinePrimaryColumn.getStyle());
        descriptionColumn.setStyle(descriptionPrimaryColumn.getStyle());
    }
}