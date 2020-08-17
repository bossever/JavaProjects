package com.ayushman;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            //check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //if there are already stocks on this item, adjust the quantity
            if (inStock != item) {
                inStock.adjustStock(item.getTotalStock());
            }

            list.put(item.getName(), item);
            System.out.println("Available stock for " + item.getName() + " : " + item.getFreeStock());
            return item.getTotalStock();
        }
        return 0;
    }

    public boolean checkStock(String item, int quantity) {
        return list.get(item).getFreeStock() >= quantity;
    }

    public boolean reserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if ((inStock != null) && ((inStock.getTotalStock() - inStock.getReservedStock()) >= quantity) && quantity > 0) {
            inStock.reserveStock(quantity);
            return true;
        }

        return false;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> priceList  = new LinkedHashMap<>();

        for (Map.Entry<String, StockItem> item : this.list.entrySet()) {
            priceList.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(priceList);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n|--------------------------- STOCK LIST --------------------------\n|\n";
        double totalCost = 0.0;

        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getTotalStock();

            s = s + "|\t- " + stockItem + " : " + stockItem.getTotalStock() + " pcs | Value of items : $" + String.format("%.2f", itemValue) + " : Reserved = " + item.getValue().getReservedStock() + " pcs\n";
            totalCost += itemValue;
        }

        return s + "|\n|------------------- TOTAL STOCK VALUE : $" + String.format("%.2f", totalCost) + " -----------------\n\n";
    }
}