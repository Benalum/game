package GUI.InformationGUI;


import GUI.HealthManaGlobes.HealthManaGlobes;
import GUI.Name.PlayerName;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import Player.Player;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;


public class InformationGUI {
    private Arc arc;
    private Arc border;
    private HealthManaGlobes globes;
    private Player currentPlayer;
    private int radius = 65;
    private PlayerName playerName;


    private static void initializationOfHealthAndManaGlobes(VBox root, Player player){
        Pane globePane = new Pane();
        //globePane.setPadding(new Insets(0,0,0,0));

        // Initialize circle stats
        HealthManaGlobes.initializeCircleStats(player.getGlobeRadius());

        // Add the globe to the pane
        HealthManaGlobes.globe(globePane);

        // update Health, update Mana
        HealthManaGlobes.updateCircle(player.getPercentHealth(), player.getPercentMana());

        // Add globe to bottom right
        root.getChildren().add(globePane);

        // Ensure the globe is properly positioned within globePane
        // You might need to adjust these values based on the size of the globe
        for (Node node : globePane.getChildren()) {
            node.setLayoutX(35); // Adjust X position
            //node.setLayoutY(30); // Adjust Y position
        }

        // Add the pane to the BorderPane looks like it doesnt effect left or right
        //BorderPane.setAlignment(globePane, Pos.BOTTOM_LEFT);
    }

    private static void initializationOfName(VBox root, Player player){
        TextFlow textFlow = new TextFlow();
        textFlow.setTextAlignment(TextAlignment.CENTER);
        PlayerName.playerName(textFlow, player.getUserName());
        root.getChildren().add(textFlow);
    }

    public static void InitializeInfoGUI(BorderPane root, Player player){
        VBox verticalBox = new VBox();
        verticalBox.setBackground(Background.fill(Color.IVORY));
        verticalBox.setBorder(Border.stroke(Color.BLACK));
        initializationOfName(verticalBox,player);
        initializationOfHealthAndManaGlobes(verticalBox, player);
        root.setBottom(verticalBox);

        }


}
