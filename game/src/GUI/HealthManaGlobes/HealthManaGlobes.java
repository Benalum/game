package GUI.HealthManaGlobes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import java.lang.Math;


public class HealthManaGlobes {
    private static Arc health;
    private static Arc borderHealth;
    private static Arc mana;
    private static Arc borderMana;
    private static int xValue = 50;
    private static int yValue = 50;
    private static int radius;

    public static void globe(Pane root){

        health = new Arc(xValue, yValue, radius, radius, 0, 0);
        borderHealth = new Arc(xValue, yValue, radius, radius, 0, 360);
        mana = new Arc(xValue + 2*radius+10, yValue, radius, radius, 0, 0);
        borderMana = new Arc(xValue + 2*radius+10, yValue, radius, radius, 0, 360);

        health.setFill(Color.LAVENDER);
        health.setStroke(Color.BLACK);
        borderHealth.setFill(Color.TRANSPARENT);
        borderHealth.setStroke(Color.BLACK);

        mana.setFill(Color.LIGHTPINK);
        mana.setStroke(Color.BLACK);
        borderMana.setFill(Color.TRANSPARENT);
        borderMana.setStroke(Color.BLACK);

        root.getChildren().addAll(health, borderHealth, mana, borderMana);
    }

    public static void updateCircle(int valueOutOfOneHundredHealth, int valueOutOfOneHundreadMana) {
        double percentHealth = valueOutOfOneHundredHealth/100.0;
        double percentMana = valueOutOfOneHundreadMana/100.0;

        double perimeterHealth = 2 * Math.PI * radius * percentHealth - radius / 3;
        double perimeterMana = 2 * Math.PI * radius * percentMana - radius / 3;

        health.setStartAngle((0 - .5 * perimeterHealth) - 90);
        health.setLength(perimeterHealth);

        mana.setStartAngle((0 - .5 * perimeterMana) - 90);
        mana.setLength(perimeterMana);

    }

    public static void initializeCircleStats(int radiuus){
        radius = radiuus;

    }
}
