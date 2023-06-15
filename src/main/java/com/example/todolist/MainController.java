package com.example.todolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private TableView table;
    @FXML private  TableColumn statusPrimaryColumn;
    @FXML private  TableColumn taskPrimaryColumn;
    @FXML private  TableColumn deadLinePrimaryColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        var data = FXCollections.observableArrayList(
                new TaskItem(new CheckBox(), "https://www.wikipedia.org/", "Наука"),
                new TaskItem(new CheckBox(), "https://store.steampowered.com/", "Развлечения"),
                new TaskItem(new CheckBox(), "https://ria.ru/", "Новости")
        );
        table.setItems(data);
        TableColumn<TaskItem, CheckBox> statusColumn = new TableColumn<TaskItem, CheckBox>("Статус");
        TableColumn<TaskItem, String> taskColumn = new TableColumn<TaskItem, String>("Задача");
        TableColumn<TaskItem, String> deadlineColumn = new TableColumn<TaskItem, String>("Дедлайн");
        statusColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, CheckBox>("status"));
        taskColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, String>("task"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<TaskItem, String>("deadline"));
        table.getColumns().set(0, statusColumn);
        table.getColumns().set(1, taskColumn);
        table.getColumns().set(2, deadlineColumn);
        statusColumn.setStyle(statusPrimaryColumn.getStyle());
        taskColumn.setStyle(taskPrimaryColumn.getStyle());
        deadlineColumn.setStyle(deadLinePrimaryColumn.getStyle());
    }
}