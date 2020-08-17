public class Point {

    private int x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt((y*y) + (x*x));
    }

    public double distance(int x , int y) {
        return Math.sqrt((this.y-y)*(this.y-y) + (this.x-x)*(this.x-x));
    }

    public double distance(Point another) {
        int xp = another.getX();
        int yp = another.getY();
        return Math.sqrt((x-xp)*(x-xp) + (y-yp)*(y-yp));
    }
}
