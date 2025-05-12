package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private final PizzaStore pizzaStore = new PizzaStore();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        root.getStyleClass().add("login-root");

        Label titleLabel = new Label("🍕 Pizza Store Login");
        titleLabel.getStyleClass().add("title-label");

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setId("usernameField");

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setId("passwordField");

        Button loginButton = new Button("Login");
        loginButton.setId("loginButton");

        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (pizzaStore.getUsername().equals(username) && pizzaStore.getPassword().equals(password)) {
                NextPage nextPage = new NextPage();
                nextPage.show(primaryStage);
            } else {
                System.out.println("Invalid credentials.");
            }
        });

        root.getChildren().addAll(titleLabel, usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Login - Pizza Store");
        primaryStage.show();
    }
}