package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class WindowLoader {
    public static Stage load(String fxmlPath) {
        Parent root;
        try {
            root = FXMLLoader.load(HelloApplication.class.getResource(fxmlPath));
            Stage stage = new Stage();
            stage.setTitle(fxmlPath);
            stage.setScene(new Scene(root));
            stage.show();
            return stage;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Scene getScene(ActionEvent event) {
        //        ((Node)(event.getSource())).getScene().getWindow().hide();
        Node node = (Node)(event.getSource());
        return node.getScene();
    }

    public static Stage getStage(ActionEvent event) {
        Scene scene = getScene(event);
        return (Stage)scene.getWindow();
    }


}
