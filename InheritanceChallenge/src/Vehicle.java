public class Vehicle {

    protected int speed;
    protected int steer;

    public Vehicle() {
        speed = 0;
        steer = 0;
    }

    public Vehicle(int speed, int steer) {
        this.speed = speed;
        this.steer = steer;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSteer() {
        return steer;
    }

    public void setSteer(int steer) {
        switch (steer) {
            case -1: this.steer = steer;
                     System.out.println("Turning left");
            case 0: this.steer = steer;
                    System.out.println("Driving straight");
            case 1: this.steer = steer;
                    System.out.println("Turning right");
            default: System.out.println("Invalid steer");
        }
    }

}
