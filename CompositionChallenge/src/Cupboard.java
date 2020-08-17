public class Cupboard {

    private int shelves;
    private Dimensions dimension;

    public Cupboard(int shelves, Dimensions dimension) {
        this.shelves = shelves;
        this.dimension = dimension;
    }

    public int getShelves() {
        return shelves;
    }

    public Dimensions getDimension() {
        return dimension;
    }
}
