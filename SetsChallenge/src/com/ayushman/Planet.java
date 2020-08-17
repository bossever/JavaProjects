package com.ayushman;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "Planet", true);
    }

    public boolean addMoon(String name, double orbitalPeriod) {
        Moon tempMoon = new Moon(name, orbitalPeriod);
        return this.addSatellite(tempMoon);
    }

    public boolean addMoon(Moon moon) {
        return this.addSatellite(moon);
    }
}
