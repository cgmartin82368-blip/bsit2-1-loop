package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Dashboard {

    private final Stage stage;
    private final BorderPane root = new BorderPane();

    private final String backgroundColor = "#F4F6F9";
    private final String navyColor = "#203354";
    private final String accentColor = "#3478A8";

    public Dashboard(Stage stage) {
        this.stage = stage;
        root.setLeft(createMenu());
        root.setStyle("-fx-background-color: " + backgroundColor + ";");
    }

    private VBox createMenu() {
        VBox menu = new VBox(12);
        menu.setPadding(new Insets(25, 15, 20, 15));
        menu.setPrefWidth(210);
        menu.setStyle("-fx-background-color: " + navyColor + ";");

        Label title = new Label("SCHOOL LIBRARY");
        title.setFont(Font.font("Arial", 18));
        title.setTextFill(Color.WHITE);
        title.setWrapText(true);

        Label subtitle = new Label("Management System");
        subtitle.setTextFill(Color.LIGHTGRAY);

        menu.getChildren().addAll(title, subtitle, new Label(" "));

        addMenuButton(menu, "Home", () -> showHome());
        addMenuButton(menu, "Books", () -> showPage("Books"));
        addMenuButton(menu, "Students", () -> showPage("Students"));
        addMenuButton(menu, "Borrow Books", () -> showPage("Borrow Books"));
        addMenuButton(menu, "Return Books", () -> showPage("Return Books"));

        VBox spacer = new VBox();
        VBox.setVgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

        Button logout = createMenuButton("Logout");
        logout.setOnAction(event -> showPage("Logout"));
        menu.getChildren().addAll(spacer, logout);

        return menu;
    }

    private Button createMenuButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER_LEFT);
        button.setPadding(new Insets(12));
        button.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-cursor: hand;"
        );
        return button;
    }

    private void addMenuButton(
            VBox menu, String text, Runnable action) {
        Button button = createMenuButton(text);
        button.setOnAction(event -> action.run());
        menu.getChildren().add(button);
    }

    public void showHome() {
        VBox content = new VBox(22);
        content.setPadding(new Insets(30));

        Label heading = new Label("Dashboard");
        heading.setFont(Font.font("Arial", 28));
        heading.setTextFill(Color.web(navyColor));

        Label welcome = new Label(
                "Welcome to the School Library Management System."
        );
        welcome.setFont(Font.font(15));

        HBox summaryCards = new HBox(15);
        summaryCards.getChildren().addAll(
                createCard("Total Books", "0"),
                createCard("Books Borrowed", "0"),
                createCard("Registered Students", "0")
        );

        Label quickActions = new Label("Quick Actions");
        quickActions.setFont(Font.font("Arial", 20));

        HBox actions = new HBox(12);
        actions.getChildren().addAll(
                createActionButton("Manage Books", "Books"),
                createActionButton("Borrow a Book", "Borrow Books"),
                createActionButton("Return a Book", "Return Books")
        );

        content.getChildren().addAll(
                heading, welcome, summaryCards, quickActions, actions
        );

        root.setCenter(content);
        updateScene();
    }

    private VBox createCard(String title, String value) {
        VBox card = new VBox(12);
        card.setPadding(new Insets(20));
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPrefWidth(200);
        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-color: #DCE2EA;" +
                        "-fx-border-radius: 8;"
        );

        Label cardTitle = new Label(title);
        cardTitle.setWrapText(true);

        Label cardValue = new Label(value);
        cardValue.setFont(Font.font("Arial", 26));
        cardValue.setTextFill(Color.web(accentColor));

        card.getChildren().addAll(cardTitle, cardValue);
        return card;
    }

    private Button createActionButton(String text, String page) {
        Button button = new Button(text);
        button.setPrefHeight(45);
        button.setPrefWidth(160);
        button.setWrapText(true);
        button.setStyle(
                "-fx-background-color: " + accentColor + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 6;" +
                        "-fx-cursor: hand;"
        );
        button.setOnAction(event -> showPage(page));
        return button;
    }

    public void showPage(String page) {
        if (page.equals("Home")) {
            showHome();
            return;
        }

        VBox content = new VBox(15);
        content.setPadding(new Insets(30));

        Label heading = new Label(page);
        heading.setFont(Font.font("Arial", 28));
        heading.setTextFill(Color.web(navyColor));

        Label message = new Label(
                page.equals("Logout")
                        ? "Logout screen will be added later."
                        : page + " screen will be added next."
        );
        message.setFont(Font.font(15));

        Button back = new Button("Back to Home");
        back.setOnAction(event -> showHome());

        content.getChildren().addAll(heading, message, back);
        root.setCenter(content);
        updateScene();
    }

    private void updateScene() {
        Scene scene = new Scene(root, 1000, 650);
        stage.setScene(scene);
    }
}
