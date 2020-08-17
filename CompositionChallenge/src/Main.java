/*      // Create a single room of a house using composition.
        // Think about the things that should be included in the room.
        // Maybe physical parts of the house but furniture as well
        // Add at least one method to access an object via a getter and
        // then that objects public method as you saw in the previous video
        // then add at least one method to hide the object e.g. not using a getter
        // but to access the object used in composition within the main class
*/

public class Main {

    public static void main(String[] args) {

        Dimensions dimensionLong = new Dimensions(6, 4);
        Dimensions dimensionShort = new Dimensions(3, 4);
        Dimensions dimensionCupboard = new Dimensions(2, 4);

        Wall wall1 = new Wall(true, false, "Sky Blue", dimensionLong);
        Wall wall2 = new Wall(false, false, "Sky Blue", dimensionShort);
        Wall wall3 = new Wall(false, true, "Sky Blue", dimensionLong);
        Wall wall4 = new Wall(false, false, "Dark Blue", dimensionShort);

        Cupboard cupboard = new Cupboard(8, dimensionCupboard);

        Furniture furniture = new Furniture(3, 1, cupboard);

        Room room1 = new Room(wall1, wall2, wall3, wall4, furniture);

        room1.describeRoom();
    }
}
