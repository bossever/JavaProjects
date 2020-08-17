package com.ayushman;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> basketList;

    public Basket(String name) {
        this.name = name;
        this.basketList = new LinkedHashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {

        if (item != null && quantity > 0) {
            int inBasket = basketList.getOrDefault(item, 0);
            basketList.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public boolean removeFromBasket(StockItem item, int quantity) {

        if (basketList.containsKey(item) && basketList.get(item) > quantity) {
            basketList.replace(item, (basketList.get(item) - quantity));
            return true;
        }
        else if (basketList.containsKey(item) && basketList.get(item) == quantity) {
            basketList.remove(item);
            return true;
        }
        else {
            System.out.println("\n * " + name + " does not have enough " + item.getName() + "s to remove! (" + basketList.getOrDefault(item, 0) + " pcs remaining)");
            return false;
        }
    }

    public Map<StockItem, Integer> getItems() {
        return Collections.unmodifiableMap(basketList);
    }

    public void clearBasket() {
        basketList.clear();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String s = "\n -------------------- " + name.toUpperCase() + " ITEM LIST ------------------- \n";
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item : basketList.entrySet()) {
            s = s + "\t- " + item.getKey() + " : " + item.getValue() + " pcs\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + " ---------------------- TOTAL COST = $" + String.format("%.2f", totalCost) + " --------------------- \n\n";
    }
}
