package com.ayushman;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int totalStock;
    private int freeStock;
    private int reservedStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.totalStock = 0;
        this.reservedStock = 0;
        this.freeStock = this.totalStock;
    }

    public StockItem(String name, double price, int totalStock) {
        this.name = name;
        this.price = price;
        this.totalStock = totalStock;
        this.reservedStock = 0;
        this.freeStock = this.totalStock;
    }

    public String getName() {
        return name;
    }

    public int getTotalStock() {
        return totalStock;
    }
    
    public int getReservedStock() {
        return reservedStock;
    }

    public int getFreeStock() {
        return freeStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void updateFreeStock() {
        freeStock = totalStock - reservedStock;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.totalStock + quantity;

        if (newQuantity >= 0) {
            totalStock = newQuantity;
        }
    }

    public boolean reserveStock(int quantity) {
        updateFreeStock();

        if (freeStock >= quantity && quantity > 0) {
            reservedStock += quantity;
            updateFreeStock();
            return true;
        }
        return false;
    }

    public boolean unreserveStock(int quantity) {
        updateFreeStock();

        if (reservedStock >= quantity && quantity > 0) {
            reservedStock = reservedStock - quantity;
            freeStock = freeStock + quantity;
            return true;
        }
        return false;
    }

    public boolean checkout(int quantity) {

        if (reservedStock >= quantity) {
            totalStock = totalStock - quantity;
            reservedStock = 0;
            updateFreeStock();
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals()");

        if (this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((StockItem) obj).getName();
        return this.getName().equals(objName);
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo()");
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.getName().compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.getName() + " : Price = $" + String.format("%.2f", this.getPrice());
    }
}
