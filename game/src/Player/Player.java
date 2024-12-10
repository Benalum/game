package Player;


import GUI.HealthManaGlobes.HealthManaGlobes;
import javafx.beans.property.DoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Player {
    private int attackPower;
    private int attackSpeed;
    private int charisma;
    private int defense;
    private boolean developer;
    private int experience;
    private int globeRadius;
    private int gold;
    private int health;
    private String imagePath;
    private ImageView imageView;
    private int intelligence;
    private List<String> items;
    private int level;
    private int lightRadius;
    private String location;
    private int mana;
    private int maxHealth;
    private int maxMana;
    private int positionHorizontal;
    private int positionVerticle;
    private int speed;
    private int wisdom;
    private int strength;
    private String userName;

         /*

    Attack Power Handling

     */

    public int getAttackPower() { return attackPower; }

    public void setAttackPower(int amount) {
        attackPower = amount;
    }

    public void addAttackPower(int amount) {
        attackPower += amount;
    }

    public void subtractAttackPower(int amount) {
        attackPower -= amount;
    }

    /*

    Attack Speed Handling

     */

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int amount) {
        attackSpeed = amount;
    }

    public void addAttackSpeed(int amount) {
        attackSpeed += amount;
    }

    public void subtractAttackSpeed(int amount) {
        attackSpeed -= amount;
    }

    /*

    Charisma Handling

     */

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int amount) {
        charisma = amount;
    }

    public void addCharisma(int amount) {
        charisma += amount;
    }

    public void subtractCharisma(int amount) {
        charisma -= amount;
    }

    /*

    Defense Handling

     */

    public int getDefense() {
        return defense;
    }

    public void setDefense(int amount) {
        defense = amount;
    }

    public void addDefense(int amount) {
        defense += amount;
    }

    public void subtractDefense(int amount) {
        defense -= amount;
    }

    /*

    Developer Handling

     */

    public boolean getDeveloper() {
        return developer;
    }

    public void setDeveloper(boolean isDev){
        developer = isDev;
    }

    /*

    Experience Handling

     */

    public int getExperience() {
        return experience;
    }

    public void setExperience(int amount) {
        experience = amount;
    }

    public void addExperience(int amount) {
        experience += amount;
    }

    public void subtractExperience(int amount) {
        experience -= amount;
    }

    /*

    //  GOLD HANDLING SECTION

     */

    public int getGold() {
        return gold;
    }

    public void setGold(int amount) {
        gold = amount;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public void subtractGold(int amount) {
        gold -= amount;
    }

    /*

    globeRadius Handling

     */
    public int getGlobeRadius(){ return globeRadius; }
    public void setGlobeRadius(int value){ globeRadius = value; }

    /*

    Health Handling

     */

    public int getPercentHealth(){
        return health * 100 / maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int amount) {
        health = amount;
    }

    public void addHealth(int amount) {
        health += amount;
    }

    public void subtractHealth(int amount) {
        health -= amount;
        if(health < 0){
            health = 0;
        }
    }

    /*

    Image Handling

     */

    public void PlayerImage(){
        imagePath = "PlayerImages/player.jpg";
        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitHeight(50); // Example height
        imageView.setFitWidth(50);  // Example width
        imageView.setX(0);          // Initial X position
        imageView.setY(0);          // Initial Y position
    }

    public void PlayerImage(String path) {
        imagePath = path;
        Image image = new Image(imagePath);
        imageView = new ImageView(image);
        imageView.setFitHeight(50); // Example height
        imageView.setFitWidth(50);  // Example width
        imageView.setX(0);          // Initial X position
        imageView.setY(0);          // Initial Y position
    }

    public void setImagePath(String path){
        System.out.print(path);
        imagePath = path;
    }

    public String returnImagePath(){
        return imagePath;
    }
    public ImageView getImageView() {
        return imageView;
    }

    // Add wrapper methods
    public double getFitHeight() {
        return imageView.getFitHeight();
    }

    public double getFitWidth() {
        return imageView.getFitWidth();
    }

    public double getX() {
        return imageView.getX();
    }

    public double getY() {
        return imageView.getY();
    }

    public void setPosition(double x, double y) {
        imageView.setX(x);
        imageView.setY(y);
    }

    // Add methods for properties
    public DoubleProperty xProperty() {
        return imageView.xProperty();
    }

    public DoubleProperty yProperty() {
        return imageView.yProperty();
    }

    /*

    isDead handling

     */

    public boolean isDead(){
        return health <= 0;
    }

    /*

    Intelligence Handling

     */

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int amount) {
        intelligence = amount;
    }

    public void addIntelligence(int amount) {
        intelligence += amount;
    }

    public void subtractIntelligence(int amount) {
        intelligence -= amount;
    }

    /*

    Inventory Handling

     */

    public void addItem(String item) {
        items.add(item);
    }

    public boolean removeItem(String item) {
        return items.remove(item);
    }

    public List<String> getItems() {
        return items;
    }

    /*

    Level Handling

     */

    public int getLevel() {
        return level;
    }

    public void setLevel(int amount) {
        level = amount;
    }

    public void addLevel(int amount) {
        level += amount;
    }

    public void subtractLevel(int amount) {
        level -= amount;
    }

    /*

    lightRadius Handling

     */

    public int getLightRadius() {
        return lightRadius;
    }

    public void setLightRadius(int amount) {
        lightRadius = amount;
    }

    public void addLightRadius(int amount) {
        lightRadius += amount;
    }

    public void subtractLightRadius(int amount) {
        lightRadius -= amount;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String input){
        location = input;
    }

    /*

    Mana Handling

     */
    public int getPercentMana(){
        return mana * 100 / maxMana;
    }
    public int getMana() {
        return mana;
    }

    public void setMana(int amount) {
        mana = amount;
    }

    public void addMana(int amount) {
        mana += amount;
    }

    public void subtractMana(int amount) {
        mana -= amount;
    }
    /*

    maxHealth Handling

     */

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int amount) {
        maxHealth = amount;
    }

    public void addMaxHealth(int amount) {
        maxHealth += amount;
    }

    public void subtractMaxHealth(int amount) {
        maxHealth -= amount;
    }

    /*

    MaxMana Handling

     */

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int amount) {
        maxMana = amount;
    }

    public void addMaxMana(int amount) {
        maxMana += amount;
    }

    public void subtractMaxMana(int amount) {
        maxMana -= amount;
    }
    /*

    positionHorizontal handling

     */

    public void moveLeft(){
        positionHorizontal -= speed;
    }
    public void moveRight(){
        positionHorizontal += speed;
    }

    public int getPositionHorizontal(){
        return positionHorizontal;
    }
    public void setPositionHorizontal(int amount){
        positionHorizontal = amount;
    }

    /*

    positionVerticle handling

     */

    public void moveUp(){
        positionVerticle -= speed;
    }
    public void moveDown(){
        positionVerticle += speed;
    }

    public int getPositionVerticle(){
        return positionVerticle;
    }
    public void setPositionVerticle(int amount){
        positionVerticle = amount;
    }

    /*

    Speed Handling

     */

    public void setSpeed(int amount){
        speed = amount;
    }
    public int getSpeed(){ return speed; }

    public void increaseSpeed(int amount){
        speed += amount;
    }

    public void decreaseSpeed(int amount) {
        speed -= amount;
    }

    /*

    Strength Handling

     */

    public int getStrength() {
        return strength;
    }

    public void setStrength(int amount) {
        strength = amount;
    }

    public void addStrength(int amount) {
        strength += amount;
    }

    public void subtractStrength(int amount) {
        strength -= amount;
    }

    /*

    widsom Handling

     */

    public int getWidsom() {
        return wisdom;
    }

    public void setWisdom(int amount) {
        wisdom = amount;
    }

    public void addWisdom(int amount) {
        wisdom += amount;
    }

    public void subtractWisdom(int amount) {
        wisdom -= amount;
    }


    /*

    UserName Handling

     */

    public String getUserName(){
        return userName;
    }
    public void setUserName(String name){
        userName = name;
    }

    public void checkUserNameExistance(String name, String[] namesSaved){
        for (String names : namesSaved){
            if (name.equals(names)){
                return;
            }
        }
        userName = name;
    }

    /*

    PlayerImage

     */

    public String getPlayerImagePath(){
        return imagePath;
    }

    public void setPlayerImage(String path){
        if(imagePath != null){
            setImagePath(path);
        }
    }

    /*
    
    Initialize player.Player
    
     */

    public void playerCreation(String name) {

        createNewStatsForPlayer(name);
    }

    /*

    Create New PlayerImage for player

     */
    /*
    private void createNewImageForPlayer(){
        player = new PlayerImage();
        this.playerImage.setImagePath("PlayerImages/player.jpg");
    }

     */

    /*

    Create New PlayerStats for player

     */

    private void createNewStatsForPlayer(String name){
        setAttackPower(10);
        setAttackSpeed(10);
        setCharisma(10);
        setDefense(10);
        setDeveloper(false);
        setExperience(100);
        setGlobeRadius(65);
        setGold(10);
        setHealth(100);
        setIntelligence(10);
        setLevel(10);
        setLightRadius(15);
        setLocation("Starting_Area");
        setMana(100);
        setMaxHealth(100);
        setMaxMana(100);
        setPositionHorizontal(1);
        setPositionVerticle(1);
        setSpeed(100);
        setWisdom(10);
        setStrength(10);
        setUserName(name);
        PlayerImage();
    }

    /*

    Damage handling

     */

    public void takeDamage(int damage){
        int healthTracker = this.getHealth()/this.maxHealth*100;
        int manaTracker = this.getMana()/this.maxHealth*100;
        HealthManaGlobes.updateCircle(healthTracker, manaTracker);
        this.subtractHealth(damage);
        if(this.isDead()){
            handleDeath();
        }
    }

    /*

    Death Handling

     */

    private void handleDeath() {
        // Implement what happens when the player dies
        // For example: Respawn, end game, show death screen, etc.
        System.out.println("player.Player has died!");
    }

    /*

    Save player.Player Stats

     */
    public void saveStats() {
        File statsFile = new File("resources/PlayerStats/playerStats.txt");
        Map<String, String> statsMap = new HashMap<>();
        String userName = getUserName();

        try {
            // Read existing stats and store in a map
            try (BufferedReader reader = new BufferedReader(new FileReader(statsFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length > 0) {
                        statsMap.put(parts[0].split(":")[1], line);
                    }
                }
            }

            // Update the stats for the specific username
            String newStats = "UserName:" + userName + ","
                    + "AttackPower:" + getAttackPower() + ","
                    + "AttackSpeed:" + getAttackSpeed() + ","
                    + "Charisma:" + getCharisma() + ","
                    + "Defense:" + getDefense() + ","
                    + "Developer:" + getDeveloper() + ","
                    + "Experience:" + getExperience() + ","
                    + "GlobeRadius:" + getGlobeRadius() + ","
                    + "Gold:" + getGold() + ","
                    + "Health:" + getHealth() + ","
                    + "Level:" + getLevel() + ","
                    + "LightRadius:" + getLightRadius() + ","
                    + "Location:" + getLocation() + ","
                    + "Mana:" + getMana() + ","
                    + "MaxHealth:" + getMaxHealth() + ","
                    + "MaxMana:" + getMaxMana() + ","
                    + "PositionHorizontal:" + getPositionHorizontal() + ","
                    + "PositionVerticle:" + getPositionVerticle() + ","
                    + "wisdom:" + getWidsom() + ","
                    + "ImagePath:" + returnImagePath();
            statsMap.put(userName, newStats);
            System.out.print("Username: " + getUserName());

            // Write the updated stats back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(statsFile))) {
                for (String userStats : statsMap.values()) {
                    writer.write(userStats + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*

    loadStats handling

     */

    public void loadStats(String userName) {
        File statsFile = new File("resources/PlayerStats/playerStats.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(statsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("UserName:" + userName + ",")) {
                    String[] statsArray = line.split(",");
                    for (String stat : statsArray) {
                        String[] keyValue = stat.split(":");
                        //System.out.print(keyValue[1] + "\n");
                        switch (keyValue[0]) {
                            case "UserName":
                                setUserName(keyValue[1]);
                                break;
                            case "AttackPower":
                                setAttackPower(Integer.parseInt((keyValue[1])));
                                break;
                            case "AttackSpeed":
                                setAttackSpeed(Integer.parseInt(keyValue[1]));
                                break;
                            case "Charisma":
                                setCharisma(Integer.parseInt(keyValue[1]));
                                break;
                            case "Defense":
                                setDefense(Integer.parseInt(keyValue[1]));
                                break;
                            case "Developer":
                                setDeveloper(Boolean.parseBoolean(keyValue[1]));
                                break;
                            case "Experience":
                                setExperience(Integer.parseInt(keyValue[1]));
                                break;
                            case "GlobeRadius":
                                setGlobeRadius(Integer.parseInt(keyValue[1]));
                                break;
                            case "Gold":
                                setGold(Integer.parseInt(keyValue[1]));
                                break;
                            case "Health":
                                setHealth(Integer.parseInt(keyValue[1]));
                                break;
                            case "Level":
                                setLevel(Integer.parseInt(keyValue[1]));
                                break;
                            case "LightRadius":
                                setLightRadius(Integer.parseInt(keyValue[1]));
                                break;
                            case "Location":
                                setLocation(keyValue[1]);
                                break;
                            case "Mana":
                                setMana(Integer.parseInt(keyValue[1]));
                                break;
                            case "MaxHealth":
                                setMaxHealth(Integer.parseInt(keyValue[1]));
                                break;
                            case "MaxMana":
                                setMaxMana(Integer.parseInt(keyValue[1]));
                                break;
                            case "PositionHorizontal":
                                setPositionHorizontal(Integer.parseInt(keyValue[1]));
                                break;
                            case "PositionVerticle":
                                setPositionVerticle(Integer.parseInt(keyValue[1]));
                                break;
                            case "wisdom":
                                setWisdom(Integer.parseInt(keyValue[1]));
                                break;
                            case "ImagePath":
                                setImagePath(keyValue[1]);
                                break;
                        }
                    }
                    //return player;
                    break; // Exit the loop once the correct user is found and stats are loaded
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return player;
    }

}
