public class Room {

    private Wall wall1, wall2, wall3, wall4;
    private Furniture furniture;

    public Room(Wall wall1, Wall wall2, Wall wall3, Wall wall4, Furniture furniture) {
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.furniture = furniture;
    }

    public void describeRoom() {

        System.out.print(" Wall 1 - \n Color = " + wall1.getColor() + " | Window = " + wall1.isHasWindow() + " | Door = " + wall1.isHasDoor() + " | Dimensions - ");
        wall1.getDimensions().print();

        System.out.print("\n Wall 2 - \n Color = " + wall2.getColor() + " | Window = " + wall2.isHasWindow() + " | Door = " + wall2.isHasDoor() + " | Dimensions - ");
        wall2.getDimensions().print();

        System.out.print("\n Wall 3 - \n Color = " + wall3.getColor() + " | Window = " + wall3.isHasWindow() + " | Door = " + wall3.isHasDoor() + " | Dimensions - ");
        wall3.getDimensions().print();

        System.out.print("\n Wall 4 - \n Color = " + wall4.getColor() + " | Window = " + wall4.isHasWindow() + " | Door = " + wall4.isHasDoor() + " | Dimensions - ");
        wall4.getDimensions().print();

        System.out.println("");

        System.out.print(" Number of chairs = " + furniture.getChairs() + " | Number of tables = " + furniture.getTables() + "\n\n Cupboard - \n Number of shelves = " + furniture.getCupboard().getShelves() + " | Dimensions = ");
        furniture.getCupboard().getDimension().print();
    }
}
