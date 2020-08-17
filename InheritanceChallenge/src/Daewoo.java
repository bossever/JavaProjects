public class Daewoo extends Car {

    public Daewoo() {
        super();
    }

    public Daewoo(int gear) {
        super(gear);
    }

    @Override
    public void setSteer(int steer) {
        switch (steer) {
            case -2: this.steer = steer;
                     System.out.println("Sharp left");
                     break;

            case -1: this.steer = steer;
                     System.out.println("Turning left");
                     break;

            case 0: this.steer = steer;
                    System.out.println("Driving straight");
                    break;

            case 1: this.steer = steer;
                    System.out.println("Turning right");
                    break;

            case 2: this.steer = steer;
                    System.out.println("Sharp right");
                    break;

            default: System.out.println("Invalid steer");
        }
    }
}
