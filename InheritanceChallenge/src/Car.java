public class Car extends Vehicle{

    protected int gear;

    Car () {
        super();
        gear = 0;
    }

    Car (int gear) {
        if (gear > -2 && gear < 6) {
            this.gear = gear;
            speed = 10 * gear;
        }
        else {
            System.out.println("Invalid gear");
            gear = 0;
            speed = 0;
        }
        steer = 0;
    }

    public void switchGear(int gear) {
        if (gear > -2 && gear < 6) {
            int multiplier = gear - this.gear;

            if (gear > 0) {
                speed += 10 * multiplier;
            }
            else if (gear == 0) {
                speed = 0;
            }
            else {
                speed = -10;
            }

            this.gear = gear;
            System.out.println("Gear changed to " + this.gear);
            System.out.println("Moving at " + speed);
        }
        else {
            System.out.println("Invalid gear shift");
        }
    }

}
