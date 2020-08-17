public class Furniture {

    private int chairs;
    private int tables;
    private Cupboard cupboard;

    public Furniture(int chairs, int tables, Cupboard cupboard) {
        this.chairs = chairs;
        this.tables = tables;
        this.cupboard = cupboard;
    }

    public Cupboard getCupboard() {
        return cupboard;
    }

    public int getChairs() {
        return chairs;
    }

    public int getTables() {
        return tables;
    }
}
