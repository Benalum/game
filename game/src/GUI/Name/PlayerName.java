package GUI.Name;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class PlayerName {
    private static final double defaultFontSize = 40;
    public static void playerName(Pane root, String playerNameString){
        TextFlow textFlow = new TextFlow();
        Text playerNameText = new Text(playerNameString);

        playerNameText.setFont(Font.font("Helvetica", FontPosture.ITALIC, defaultFontSize));
        playerNameText.setFill(Color.BLACK);

        textFlow.getChildren().add(playerNameText);
        root.getChildren().add(textFlow);

    }
    public void initializePlayerName(Pane root, String playerNameString){
        playerName(root, playerNameString);

    }
}
