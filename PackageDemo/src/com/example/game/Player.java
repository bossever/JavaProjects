package com.example.game;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String playerName;
    private int playerHealth;
    private String primaryWeapon;
    private int primaryWeaponDamage;

    public Player(String playerName, String primaryWeapon) {
        this.playerName = playerName;
        this.playerHealth = 100;
        this.primaryWeapon = primaryWeapon;
        this.primaryWeaponDamage = 15;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public String getPrimaryWeapon() {
        return primaryWeapon;
    }

    public void setPrimaryWeapon(String primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }

    public int getPrimaryWeaponDamage() {
        return primaryWeaponDamage;
    }

    public void setPrimaryWeaponDamage(int primaryWeaponDamage) {
        this.primaryWeaponDamage = primaryWeaponDamage;
    }

    @Override
    public List<String> write() {

        List<String> valuesArray = new ArrayList<String>();
        valuesArray.add(0, this.playerName);
        valuesArray.add(1, "" + playerHealth);
        valuesArray.add(2, primaryWeapon);
        valuesArray.add(3, "" + primaryWeaponDamage);
        return valuesArray;
    }

    @Override
    public void read(List<String> savedValues) {

        if (savedValues != null && savedValues.size() > 0) {
            playerName = savedValues.get(0);
            playerHealth = Integer.parseInt(savedValues.get(1));
            primaryWeapon = savedValues.get(2);
            primaryWeaponDamage = Integer.parseInt(savedValues.get(3));
            System.out.println("Field values for " + playerName + " loaded.");
        }
        else {
            System.out.println("Save file not found.");
        }
    }

    @Override
    public String toString() {
        return playerName + " with health " + playerHealth + " has weapon " + primaryWeapon + " with damage " + primaryWeaponDamage;
    }
}
