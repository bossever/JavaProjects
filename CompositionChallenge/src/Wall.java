public class Wall {

    private boolean hasWindow, hasDoor;
    private String color;
    private Dimensions dimensions;

    public Wall(boolean hasWindow, boolean hasDoor, String color, Dimensions dimensions) {
        this.hasWindow = hasWindow;
        this.hasDoor = hasDoor;
        this.color = color;
        this.dimensions = dimensions;
    }

    public boolean isHasWindow() {
        return hasWindow;
    }

    public boolean isHasDoor() {
        return hasDoor;
    }

    public String getColor() {
        return color;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
