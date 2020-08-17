import java.util.ArrayList;
import java.util.List;

public class Monsters implements ISaveable {

    private String monsterType;
    private int monsterHealth;
    private int monsterDamage;

    public Monsters(String monsterType, int monsterHealth) {
        this.monsterType = monsterType;
        this.monsterHealth = monsterHealth;
        this.monsterDamage = 10;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    } 

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }

    @Override
    public List<String> write() {

        List<String> valuesArray = new ArrayList<String>();
        valuesArray.add(0, this.monsterType);
        valuesArray.add(1, "" + monsterHealth);
        valuesArray.add(2, "" + monsterDamage);
        return valuesArray;
    }

    @Override
    public void read(List<String> savedValues) {

        if (savedValues != null && savedValues.size() > 0) {
            monsterType = savedValues.get(0);
            monsterHealth = Integer.parseInt(savedValues.get(1));
            monsterDamage = Integer.parseInt(savedValues.get(2));
            System.out.println("Field values for " + monsterType + " loaded.");
        }
        else {
            System.out.println("Save file not found.");
        }
    }

    @Override
    public String toString() {
        return monsterType + " with health " + monsterHealth + " has damage " + monsterDamage;
    }
}
