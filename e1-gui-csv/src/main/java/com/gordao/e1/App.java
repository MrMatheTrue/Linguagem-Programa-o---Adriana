package com.gordao.e1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader fxml = new FXMLLoader(App.class.getResource("MainView.fxml"));
    Scene scene = new Scene(fxml.load(), 840, 560);
    stage.setTitle("E1 - Formulários CSV");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
