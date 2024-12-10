package MapHandlers;

import Logging.AppLogger;
import GUI.Login.LoginMenu;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import Player.Player;


public class MapGUI extends Application {
    private Stage primaryStage;
    private MapManager mapManager;
    private Player player;
    public MapGUI(Player player) {
        this.player = player;
    }
    private int currentMapIndex = 0;

    //private GUI.MapHandlers.MapType[] mapTypes = {GUI.MapHandlers.MapType.MAP_1, GUI.MapHandlers.MapType.MAP_2, GUI.MapHandlers.MapType.MAP_3, GUI.MapHandlers.MapType.MAP_4};

    @Override
    public void start(Stage primaryStage) {
        //Log successful login
        AppLogger.logInfo("Username: " + player.getUserName() + " had a sucessful login");

        // Initialize
        this.primaryStage = primaryStage;
        mapManager = new MapManager();
        selectMap(player.getLocation());

        if (player != null) {
            String playerName = player.getUserName();
            // Use the player object to access player information and update the map
        } else {
            AppLogger.logError("Error: player.Player Object is Null");
            // Handle the null player object case appropriately
        }
    }

    private void updateMap(MapType selectedMap) {
        // Assuming mapManager is an instance of GUI.MapHandlers.MapManager
        mapManager.switchMap(selectedMap, player);

        // Update the GUI to reflect the new map
        // This can include changing the layout, loading new content, etc.
        // For demonstration, let's just update the title for now
        primaryStage.setTitle("Map Selection - " + player.getUserName() + " - " + selectedMap.getDisplayName());

        // Additional GUI updates can be added here
    }

    // Method to open the login menu
    private void openLoginMenu() {
        Stage loginStage = new Stage();
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.start(loginStage);
    }

    public void selectMap(String mapName) {
        for (MapType type : MapType.values()) {
            if (type.getDisplayName().equalsIgnoreCase(mapName)) {
                // Code to handle the map selection
                // For example, updating the currentMapIndex or calling GUI.MapHandlers.MapManager
                // Assuming updateMap() is a method that updates the GUI
                updateMap(type);
                return;
            }
        }
        // Handle case where no map matches the given string
        showInformationAlert("Map doesn't exist. Please report. Setting to Start Area");
        selectMap("Areas.StartingArea.StartArea");
    }
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
