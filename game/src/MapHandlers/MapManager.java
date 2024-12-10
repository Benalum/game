package MapHandlers;


import Areas.StartingArea.StartArea;
import GUI.InformationGUI.InformationGUI;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;
import Player.Player;


public class MapManager {
    private Player player;
    public void switchMap(MapType mapType, Player player) {
        switch (mapType) {
            case Starting_Area:
                // Areas.StartingArea.StartArea
                setupStartArea(player);
                // Load map 1
                break;
            case MAP_2:
                // Load map 2
                break;
            case MAP_3:
                // Load map 3
                break;
            case MAP_4:
                // Load map 4
                break;
            default:
                System.out.println("Invalid map type");
        }
    }
    private void setupStartArea(Player player) {
        BorderPane startArea = new BorderPane();
        GridPane mapPane = new GridPane();

        // Set the maximum size to the preferred size to prevent expanding
        mapPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        InformationGUI.InitializeInfoGUI(startArea, player);

        Scene startScene = new Scene(startArea);
        StartArea.initializeStartArea(mapPane);
        startArea.setCenter(mapPane);

        Stage startStage = new Stage();
        startStage.setScene(startScene);
        startStage.setTitle("Starting Area");
        startStage.setFullScreen(true);

        // Add listener to fullScreenProperty to handle exit from full screen
        startStage.fullScreenProperty().addListener((obs, wasFullScreen, isNowFullScreen) -> {
            if (!isNowFullScreen) {
                handleFullScreenExit(startStage);
            }
        });

        startStage.show();
    }

    private void handleFullScreenExit(Stage stage) {
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        stage.setWidth(visualBounds.getWidth());
        stage.setHeight(visualBounds.getHeight());
        stage.setX((Screen.getPrimary().getBounds().getWidth() - visualBounds.getWidth()) / 2);
        stage.setY((Screen.getPrimary().getBounds().getHeight() - visualBounds.getHeight()) / 2);
    }
}