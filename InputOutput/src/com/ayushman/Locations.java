package com.ayushman;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static final Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {

            for (Location location : locations.values()) {
                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());

                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);

                for (String direction : location.getExits().keySet()) {

                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }

            }
        }
    }

    static {

        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {

            while(true) {
                Map<String, Integer> exits = new LinkedHashMap<>();
                int locID = locFile.readInt();
                String description = locFile.readUTF();
                int numExits = locFile.readInt();
                System.out.println("Read location " + locID + " : " + description + "\n" + "Found " + numExits + " exits.");

                for (int i = 0; i < numExits; i++) {
                    String direction = locFile.readUTF();
                    int destination = locFile.readInt();
                    exits.put(direction, destination);
                    System.out.println("\t\t" + direction + "," + destination);
                }
                locations.put(locID, new Location(locID,description, exits));
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }


//        /*-------NOW READING "locations_big.txt"-------*/
//
//        System.out.println("Reading file \"locations_big.txt\" --> ");
//
//        try (BufferedReader locReader = new BufferedReader(new FileReader("locations_big.txt"))) {      //Using a buffered reader because there is no need of a scanner, would make things unnecessarily complicated
//
//            String input;
//
//            while ((input = locReader.readLine()) != null) {            //Reading one line at a time and using split() method
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String description = data[1];
//
//                System.out.println("Imported loc: " + loc + " : " + description);
//                Map<String, Integer> tempExit = new LinkedHashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("\n  ** An error occurred while reading \"locations_big.txt\" **");
//        }
//
//
//        /*-------NOW READING "directions_big.txt"-------*/
//
//        System.out.println("\nReading file \"directions_big.txt\" -->");
//
//        try (BufferedReader dirReader = new BufferedReader(new FileReader("directions_big.txt"))) {
//
//            String input;
//
//            while ((input = dirReader.readLine()) != null) {            //Method 2, reading one line at a time and using the split() method
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("\n  ** An error occurred while reading \"directions_big.txt\" **");
//        }


//        //Initializing locations and exits
//        tempExit = new HashMap<>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest", tempExit));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
