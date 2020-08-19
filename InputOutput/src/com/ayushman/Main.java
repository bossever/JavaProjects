package com.ayushman;

    // Change the program to allow players to type full words, or phrases, then move to the
    // correct location based upon their input.
    // The player should be able to type commands such as "Go West", "run South", or just "East"
    // and the program will move to the appropriate location if there is one.  As at present, an
    // attempt to move in an invalid direction should print a message and remain in the same place.
    //
    // Single letter commands (N, W, S, E, Q) should still be available.


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Locations locations = new Locations();
    private static final Map<String, String> directions = new HashMap<>();

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        //Initializing directions
        directions.put("NORTH", "N");
        directions.put("SOUTH", "S");
        directions.put("EAST", "E");
        directions.put("WEST", "W");
        directions.put("QUIT", "Q");


        int loc = 1;

        while (true) {
            System.out.println(locations.get(loc).getDescription());

            if (loc == 0)
                break;
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are : ");

            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) {
                String[] inputWords = direction.split(" ");

                for (String currentWord : inputWords) {

                    if (directions.containsKey(currentWord)) {
                        direction = directions.get(currentWord);
                        break;
                    }
                }
            }


            if (direction == null) {
                System.out.println("I do not understand that!");
            } else if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}


//a
//a
//        a
//a
//                a
//a
//                        a
//a
//                                a
//a
//                                        a
//a
//                                                a
//a
//                                                        a
//a
//                                                                a

