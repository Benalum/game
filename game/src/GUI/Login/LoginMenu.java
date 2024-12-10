package GUI.Login;


import MapHandlers.MapGUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Player.Player;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class LoginMenu extends Application {
    private UserManager userManager;
    private Player userPlayer;
    @Override
    public void start(Stage primaryStage) {
        // Create controls for login
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");

        // Create controls for creating a new account
        TextField newUsernameField = new TextField();
        PasswordField newPasswordField = new PasswordField();
        TextField emailField = new TextField();
        Button createAccountButton = new Button("Create Account");

        // Set actions for login button
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            try {
                if (userManager.validateCredentials(username, password)) {
                    userPlayer.loadStats(username);
                    primaryStage.close();
                    openMap(userPlayer);
                } else {
                    // Show an error message for invalid credentials
                    showErrorAlert("Invalid username or password!");
                }
            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
                // Handle IOException appropriately
            }
        });

        // Set actions for create account button
        createAccountButton.setOnAction(event -> {
            String newUsername = newUsernameField.getText();
            String newPassword = newPasswordField.getText();
            String email = emailField.getText();
            try {
                userManager.createNewAccount(newUsername, newPassword, email);
                userPlayer.playerCreation(newUsername);
                userPlayer.saveStats();
                primaryStage.close();
                openMap(userPlayer);

                // Show success message for account creation
                showInformationAlert("Account created successfully!");
            } catch (IOException e) {
                e.printStackTrace();
                // Handle IOException appropriately
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        });

        // Create a VBox to hold login and create account components
        VBox loginLayout = new VBox(10);
        loginLayout.getChildren().addAll(
                new Label("Username:"),
                usernameField,
                new Label("Password:"),
                passwordField,
                loginButton,
                new Label("Create Account:"),
                new Label("New Username:"),
                newUsernameField,
                new Label("New Password:"),
                newPasswordField,
                new Label("Email:"),
                emailField,
                createAccountButton
        );

        loginLayout.setPadding(new Insets(10));

        // Create the scene and set it on the stage
        Scene scene = new Scene(loginLayout, 300, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public LoginMenu() {
        this.userPlayer = new Player();
        this.userManager = new UserManager();
    }

    // Open the map GUI
    private void openMap(Player username) {
        Stage mapStage = new Stage();
        MapGUI mapGUI = new MapGUI(username);
        mapGUI.start(mapStage);
    }

    // Method to show error alert
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to show information alert
    private void showInformationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
