package MapHandlers;

public enum MapType {
    Starting_Area("Starting_Area"),
    MAP_2("Map 2"),
    MAP_3("Map 3"),
    MAP_4("Map 4");

    private final String displayName;

    MapType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int length(){return MapType.values().length;}
}
