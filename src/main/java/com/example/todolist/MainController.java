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

    @FXML private void onCreateNewTask(ActionEvent event) {
        WindowLoader.load("task.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AppData.tasks = FXCollections.observableArrayList(
                new TaskItem(new CheckBox(), "Walk the dog/", LocalDate.now()),
                new TaskItem(new CheckBox(), "Read the book", LocalDate.now()),
                new TaskItem(new CheckBox(), "Play a game", LocalDate.now())
        );
        table.setItems(AppData.tasks);
        TableColumn<TaskItem, CheckBox> statusColumn = new TableColumn<TaskItem, CheckBox>("Статус");
        TableColumn<TaskItem, String> taskColumn = new TableColumn<TaskItem, String>("Задача");
        TableColumn<TaskItem, LocalDate> deadlineColumn = new TableColumn<TaskItem, LocalDate>("Дедлайн");
        statusColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, CheckBox>("status"));
        taskColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, String>("task"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, LocalDate>("deadline"));
        table.getColumns().set(0, statusColumn);
        table.getColumns().set(1, taskColumn);
        table.getColumns().set(2, deadlineColumn);
        statusColumn.setStyle(statusPrimaryColumn.getStyle());
        taskColumn.setStyle(taskPrimaryColumn.getStyle());
        deadlineColumn.setStyle(deadLinePrimaryColumn.getStyle());
    }
}