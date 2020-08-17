package com.ayushman;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final Key key;
    private final double orbitalPeriod;
    private final boolean hasSatellites;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, String bodyType, boolean hasSatellites) {
        this.orbitalPeriod = orbitalPeriod;
        this.hasSatellites = hasSatellites;
        this.key = new Key(name, bodyType);

        if (hasSatellites) {
            this.satellites = new HashSet<>();
        }
        else {
            this.satellites = null;
        }
    }

    public Key getKey() {
        return key;
    }

    public boolean getHasSatellites() {
        return hasSatellites;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody body = (HeavenlyBody) obj;
            return this.key.equals(body.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.getKey().hashCode();
    }

    public static final class Key{
        private final String name;
        private final String bodyType;

        public Key(String name, String bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public String getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 50;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;

            if (this.name.equals(key.getName())) {
                return this.bodyType.equals(key.getBodyType());
            }
            return false;
        }
    }
}
