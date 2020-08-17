package com.ayushman;
/*
        Modify the previous HeavenlyBody example so that the HeavenlyBody
        class also has a "bodyType" field. This field will store the
        type of HeavenlyBody (such as STAR, PLANET, MOON, etc).

        You can include as many types as you want, but must support at
        least PLANET and MOON.

        For each of the types that you support, subclass the HeavenlyBody class
        so that your program can create objects of the appropriate type.

        Although astronomers may shudder at this, our solar systems will
        allow two bodies to have the same name as long as they are not the
        same type of body: so you could have a star called "BetaMinor" and
        an asteroid also called "BetaMinor", for example.

        Hint: This is much easier to implement for the Set than it is for the Map,
        because the Map will need a key that uses both fields.

        There is a restriction that the only satellites that planets can have must
        be moons. Even if you don't implement a STAR type, though, your program
        should not prevent one being added in the future (and a STAR's satellites
        can be almost every kind of HeavenlyBody).

        Test cases:
        1. The planets and moons that we added in the previous video should appear in
        the solarSystem collection and in the sets of moons for the appropriate planets.

        2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.

        3. Attempting to add a duplicate to a Set must result in no change to the set (so
        the original value is not replaced by the new one).

        4. Attempting to add a duplicate to a Map results in the original being replaced
        by the new object.

        5. Two bodies with the same name but different designations can be added to the same set.

        6. Two bodies with the same name but different designations can be added to the same map,
        and can be retrieved from the map.
*/

import java.util.*;

public class Main {

    public static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();

    public static Set<HeavenlyBody> stars = new HashSet<>();
    public static Set<HeavenlyBody> planets = new HashSet<>();
    public static Set<HeavenlyBody> moons = new HashSet<>();
    public static Set<HeavenlyBody> asteroids = new HashSet<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Planet temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        System.out.println(planets.add(temp));
        System.out.println(planets.add(temp));

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

//        addStar();
//        addPlanet();
//        addAsteroid();

        printSet(stars);
        printSet(planets);
        printSet(asteroids);

        printMap(solarSystem);
    }

    public static void printSet(Set<HeavenlyBody> set) {

        for (HeavenlyBody heavenlyBody : set) {
            System.out.println();
            System.out.println(" | Name : " + heavenlyBody.getKey().getName() + "\n | Heavenly Body Type : " + heavenlyBody.getKey().getBodyType() + "\n | Orbital Period : " + heavenlyBody.getOrbitalPeriod());

            if (heavenlyBody.getHasSatellites() && heavenlyBody.getSatellites().size() > 0) {
                System.out.println("\nNatural Satellites : ");
                printSet(heavenlyBody.getSatellites());
            }
        }
        System.out.println();
    }

    public static void printMap(Map<HeavenlyBody.Key, HeavenlyBody> map) {

        System.out.println();
        for (HeavenlyBody heavenlyBody : map.values()) {
            System.out.println(heavenlyBody.getKey().getName() + "\t| " + heavenlyBody.getKey().getBodyType() + "\t| Orbital Period : " + heavenlyBody.getOrbitalPeriod());
        }
    }

    public static boolean addStar() {
        System.out.print("Enter the star's name : ");
        String name = scanner.nextLine();
        Star tempStar = new Star(name);
        System.out.print("Add " + tempStar.getKey().getName() + " to solar system? ");

        while (true) {
            String yesOrNo = scanner.nextLine().toLowerCase().trim();

            if (yesOrNo.equals("y") || yesOrNo.equals("yes")) {
                solarSystem.put(tempStar.getKey(), tempStar);
                break;
            } else if (yesOrNo.equals("n") || yesOrNo.equals("no")) {
                break;
            }
            else {
                System.out.print("What? ");
            }
        }
        return stars.add(tempStar);
    }

    public static boolean addPlanet() {
        System.out.print("Enter the planet's name : ");
        String name = scanner.nextLine();
        System.out.print("Enter orbital period : ");
        double orbitalPeriod = scanner.nextInt();
        scanner.nextLine();
        Planet tempPlanet = new Planet(name, orbitalPeriod);

        while (true) {
            System.out.print("Add moon(s) to " + tempPlanet.getKey().getName() + "? ");
            String yesOrNo = scanner.nextLine().toLowerCase().trim();

            if (yesOrNo.equals("y") || yesOrNo.equals("yes")) {
                tempPlanet.addSatellite(addMoon());
                break;
            } else if (yesOrNo.equals("n") || yesOrNo.equals("no")) {
                break;
            }
            else {
                System.out.print("What? ");
            }

        }

        System.out.print("Add " + tempPlanet.getKey().getName() + " to solar system? ");
        while (true) {
            String yesOrNo = scanner.nextLine().toLowerCase().trim();

            if (yesOrNo.equals("y") || yesOrNo.equals("yes")) {
                solarSystem.put(tempPlanet.getKey(), tempPlanet);
                break;
            } else if (yesOrNo.equals("n") || yesOrNo.equals("no")) {
                break;
            }
            else {
                System.out.print("What? ");
            }
        }
        return planets.add(tempPlanet);
    }

    public static HeavenlyBody addMoon() {
        System.out.print("Enter the moon's name : ");
        String name = scanner.nextLine();
        System.out.print("Enter orbital period : ");
        double orbitalPeriod = scanner.nextInt();
        scanner.nextLine();
        Moon tempMoon = new Moon(name, orbitalPeriod);
        moons.add(tempMoon);
        return tempMoon;
    }

    public static boolean addAsteroid() {
        System.out.print("Enter the asteroid's name : ");
        String name = scanner.nextLine();
        System.out.print("Enter orbital period : ");
        double orbitalPeriod = scanner.nextInt();
        scanner.nextLine();
        Asteroid tempAsteroid = new Asteroid(name, orbitalPeriod);
        System.out.print("Add " + tempAsteroid.getKey().getName() + " to solar system? ");

        while (true) {
            String yesOrNo = scanner.nextLine().toLowerCase().trim();
            if (yesOrNo.equals("y") || yesOrNo.equals("yes")) {
                solarSystem.put(tempAsteroid.getKey(), tempAsteroid);
                break;
            } else if (yesOrNo.equals("n") || yesOrNo.equals("no")) {
                break;
            } else {
                System.out.print("What? ");
            }
        }
        return asteroids.add(tempAsteroid);
    }
}
