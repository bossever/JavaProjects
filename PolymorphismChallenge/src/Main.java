/*	    // We are going to go back to the car analogy.
        // Create a base class called Car
        // It should have a few fields that would be appropriate for a generic car class.
        // engine, cylinders, wheels, etc.
        // Constructor should initialize cylinders (number of) and name, and set wheels to 4
        // and engine to true. Cylinders and names would be passed parameters.
        //
        // Create appropriate getters
        //
        // Create some methods like startEngine, accelerate, and brake
        //
        // show a message for each in the base class
        // Now create 3 sub classes for your favorite vehicles.
        // Override the appropriate methods to demonstrate polymorphism in use.
        // put all classes in the one java file (this one).
 */
 class Car {

    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String getName() {
        return name;
    }

    public void startEngine() {
        System.out.println("Car -> startEngine");
    }

    public void accelerate() {
        System.out.println("Car -> accelerate");
    }

    public void brake() {
        System.out.println("Car -> brake");
    }
 }

 class Lamborghini extends Car {

     public Lamborghini(String name, int cylinders) {
         super(name, cylinders);
     }

     @Override
     public void startEngine() {
         System.out.println("Lamborghini " + getName() + "-> startEngine");
     }

     @Override
     public void accelerate() {
         System.out.println("Lamborghini " + getName() + "-> accelerate");
     }

     @Override
     public void brake() {
         System.out.println("Lamborghini " + getName() + "-> brake");
     }
 }

 class Porsche extends Car {

     public Porsche(String name, int cylinders) {
         super(name, 8);
     }

     @Override
     public void startEngine() {
         System.out.println("Porsche " + getName() + "-> startEngine");
     }

     @Override
     public void accelerate() {
         System.out.println("Porsche " + getName() + "-> accelerate");
     }

     @Override
     public void brake() {
         System.out.println("Porsche " + getName() + "-> brake");
     }
 }


public class Main {

    public static void main(String[] args) {

        Lamborghini myLambo = new Lamborghini("Aventador", 8);
        myLambo.startEngine();
        myLambo.accelerate();
        myLambo.brake();

        Porsche myPorsche = new Porsche("911 Turbo", 8);
        myPorsche.startEngine();
        myPorsche.accelerate();
        myPorsche.brake();
    }
}
