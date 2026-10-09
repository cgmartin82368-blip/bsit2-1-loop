
package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Dashboard dashboard = new Dashboard(stage);
        dashboard.showHome();

        stage.setTitle("School Library Management System");
        stage.setMinWidth(850);
        stage.setMinHeight(550);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
