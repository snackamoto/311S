package org.example.lab311w4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class HelloApplication extends Application {
    private Stage primaryStage;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showSplashScreen();
    }

    private void showSplashScreen() {
        Label splashLabel = new Label("FSC Homepage");
        StackPane splashLayout = new StackPane(splashLabel);
        Scene splashScene = new Scene(splashLayout, 1000, 1000);
        splashScene.getStylesheets().add(getClass().getResource("animation.css").toExternalForm()); // css
        primaryStage.setScene(splashScene);
        primaryStage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event -> showLoginScreen()); // Lambda over innerclasses
        delay.play();
    }

    private void showLoginScreen() {
        Label loginLabel = new Label("Login to Farmingdale");
        Button loginButton = new Button("Login to your Account");
        loginButton.getStyleClass().add("button");
        loginButton.setOnAction(e -> showUsernamePasswordPage());

        Button registerButton = new Button("Register New Account");
        registerButton.getStyleClass().add("button");
        registerButton.setOnAction(e -> showRegistrationScreen());

        VBox loginLayout = new VBox(10, loginLabel, loginButton, registerButton);
        loginLayout.getStyleClass().add("vbox");
        Scene loginScene = new Scene(loginLayout, 1000, 1000);
        loginScene.getStylesheets().add(getClass().getResource("animation.css").toExternalForm()); // css file
        primaryStage.setScene(loginScene);
    }

    private void showUsernamePasswordPage() {
        Label usernameLabel = new Label("Username: ");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password: ");
        PasswordField passwordField = new PasswordField();

        Button submitButton = new Button("Submit");
        submitButton.getStyleClass().add("button");
        submitButton.setOnAction(e -> showLandingScreen());

        VBox usernamePasswordLayout = new VBox(50, usernameLabel, usernameField, passwordLabel, passwordField, submitButton);
        usernamePasswordLayout.getStyleClass().add("vbox");
        Scene usernamePasswordScene = new Scene(usernamePasswordLayout, 1000, 1000);
        usernamePasswordScene.getStylesheets().add(getClass().getResource("animation.css").toExternalForm());
        primaryStage.setScene(usernamePasswordScene);
    }

    private void showRegistrationScreen() {
        Label registerLabel = new Label("Register");
        Button registerButton = new Button("Enter");
        registerButton.getStyleClass().add("button"); // Apply button styles
        registerButton.setOnAction(e -> showLandingScreen()); // Lambda expression for event handler

        VBox registerLayout = new VBox(100, registerLabel, registerButton);
        registerLayout.getStyleClass().add("vbox"); // Apply VBox style
        Scene registerScene = new Scene(registerLayout, 1000, 1000);
        registerScene.getStylesheets().add(getClass().getResource("animation.css").toExternalForm());
        primaryStage.setScene(registerScene);
    }

    private void showLandingScreen() {
        Label landingLabel = new Label("Welcome to Brightspace");
        VBox landingLayout = new VBox(100, landingLabel);
        landingLayout.getStyleClass().add("vbox");
        Scene landingScene = new Scene(landingLayout, 1000, 1000);
        landingScene.getStylesheets().add(getClass().getResource("animation.css").toExternalForm());
        primaryStage.setScene(landingScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
