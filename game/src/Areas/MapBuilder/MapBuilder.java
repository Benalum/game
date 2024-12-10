package Areas.MapBuilder;


import Areas.ImageFinder.ImageFinder;
import MapHandlers.MapType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MapBuilder {

    private GridPane gridPane;

    public MapBuilder(MapType mapType,GridPane gridPane) {
        if (mapType == MapType.Starting_Area) {
            String[][] map = readTextFile("resources/Maps/StartingArea/StartingArea.txt");
            //assert map != null;
            buildMap(map, gridPane);
        }else{
            System.out.println("Error no map found");
        }
    }

    private String[][] readTextFile(String locationOfFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(locationOfFile))) {
            String size = reader.readLine();
            String[] sizes = size.split("x");
            int row = Integer.parseInt(sizes[0]);
            System.out.println("Row: " + row);
            int col = Integer.parseInt(sizes[1]);
            System.out.println("Col: " + col);
            int index = 0;
            String line;
            String[][] map = new String[row][col];
            while ((line = reader.readLine()) != null && index < row) {
                String[] lineSections = line.split(",");
                System.out.println(lineSections.toString());
                for(int i = 0; i < col; i++){
                    map[index][i] = lineSections[i];
                }
                index++;
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Can not Map, Map issue 12357");
        return null;
    }

    private void buildMap(String[][] mapText, GridPane gridPane) {
        for (int i = 0; i < mapText.length; i++) {
            for (int j = 0; j < mapText[i].length; j++) {
                Pane square = new Pane();
                square.setPrefSize(50, 50);
                String line = mapText[i][j];
                String[] lineSections = line.split("-");
                for (String section : lineSections) {
                    ImageView imageView = ImageFinder.findImage(section);
                    if (imageView != null) {
                        // Resize the image to fit the 50x50 square
                        imageView.setFitWidth(50);
                        imageView.setFitHeight(50);
                        square.getChildren().add(imageView);
                    }
                }
                // Add the square (Pane) to the GridPane
                gridPane.add(square, j, i);
            }
        }
    }
}