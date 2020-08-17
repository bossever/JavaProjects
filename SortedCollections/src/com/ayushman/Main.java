package com.ayushman;

/*
                                    CHALLENGE
    *Modify the program so that adding items to the shopping basket doesn't
     actually reduce the stock count but, instead, reserves the requested
     number of items.

    *You will need to add a "reserved" field to the StockItem class to store the
     number of items reserved.

    *Items can continue to be added to the basket, but it should not be possible to
     reserve more than the available stock of any item. An item's available stock
     is the stock count minus the reserved amount.

    *The stock count for each item is reduced when a basket is checked out, at which
     point all reserved items in the basket have their actual stock count reduced.

    *Once checkout is complete, the contents of the basket are cleared.

    *It should also be possible to "unreserve" items that were added to the basket
     by mistake.

    *The program should prevent any attempt to unreserve more items than were
     reserved for a basket.

    *Add code to Main that will unreserve items after they have been added to the basket,
     as well as unreserving items that have not been added to make sure that the code
     can cope with invalid requests like that.

    *After checking out the baskets, display the full stock list and the contents of each
     basket that you created.
*/

import java.util.Map;

public class Main {

    private static final StockList stockList = new StockList();
    private static final Basket basket1 = new Basket("Ashu's Basket");
    private static final Basket basket2 = new Basket("Omang's Basket");

    public static void main(String[] args) {

        addDummyStock(stockList);
        System.out.println(stockList);

        reserveItemsForPurchase(basket1, "Car", 1);
        reserveItemsForPurchase(basket1, "Spanner", 1);     //shows that there is no such item as a spanner in stock
        reserveItemsForPurchase(basket1, "Juice", 4);
        reserveItemsForPurchase(basket1, "Cup", 12);
        reserveItemsForPurchase(basket1, "Bread", 1);

        reserveItemsForPurchase(basket2, "Cake", 3);
        reserveItemsForPurchase(basket2, "Car", 1);
        reserveItemsForPurchase(basket2, "Dog", 3);
        reserveItemsForPurchase(basket2, "Laptop", 1);
        reserveItemsForPurchase(basket2, "Mattress", 2);
        reserveItemsForPurchase(basket2, "Oreo", 12);
        reserveItemsForPurchase(basket2, "Tractor", 1);

        unreserveItems(basket1, "Car", 1);
//        System.out.println("\n" + basket1);
        checkout(basket1);

        unreserveItems(basket2, "Oreo", 2);
//        System.out.println("\n" + basket2);
        checkout(basket2);

        System.out.println(stockList);
    }

    public static void addDummyStock(StockList stockList) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);
        temp = new StockItem("Car", 12.50, 2);
        stockList.addStock(temp);
        temp = new StockItem("Chair", 62.00, 10);
        stockList.addStock(temp);
        temp = new StockItem("Cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("Dog", 1000.50, 8);
        stockList.addStock(temp);
        temp = new StockItem("Door", 72.95, 4);
        stockList.addStock(temp);
        temp = new StockItem("Juice", 2.50, 36);
        stockList.addStock(temp);
        temp = new StockItem("Laptop", 999, 50);
        stockList.addStock(temp);
        temp = new StockItem("Mattress", 49.99, 200);
        stockList.addStock(temp);
        temp = new StockItem("Oreo", 7.50, 400);
        stockList.addStock(temp);
        temp = new StockItem("Phone", 699, 1);
        stockList.addStock(temp);
        temp = new StockItem("Shovel", 20.00, 30);
        stockList.addStock(temp);
        temp = new StockItem("Towel", 2.40, 4);
        stockList.addStock(temp);
        temp = new StockItem("Tractor", 15000, 15);
        stockList.addStock(temp);
        temp = new StockItem("Vase", 18.50, 3);
        stockList.addStock(temp);
    }


    public static int reserveItemsForPurchase(Basket basket, String item, int quantity) {
        //retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);

        if (stockItem == null) {
            System.out.println("\n * We don't sell " + item + "!");
            return 0;
        }

        if (stockList.checkStock(item, quantity)) {
            stockList.reserveStock(item, quantity);
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        else {
            System.out.println("\n * Not enough " + item + "s in stock! (" + stockList.get(item).getFreeStock() + " pcs remaining)");
        }

        return 0;
    }

    public static int unreserveItems(Basket basket, String item, int quantity) {

        if (basket.removeFromBasket(stockList.get(item), quantity)) {
            stockList.get(item).unreserveStock(quantity);
            System.out.println("\n * Unreserved " + quantity + " " + item + "(s) from " + basket.getName() + ".");
            return quantity;
        }
        else {
            System.out.println("\n * An error occurred and the items could not be unreserved. ");
            return 0;
        }
    }

    public static boolean checkout(Basket basket) {
        Map<StockItem, Integer> basketList = basket.getItems();
        boolean error = false;

        for (Map.Entry<StockItem, Integer> item : basketList.entrySet()) {
            int stockItemReserved = stockList.get(item.getKey().getName()).getReservedStock();

            if ((item.getValue() > stockItemReserved)) {
                error = true;
                break;
            }
        }

        if (error) {
            System.out.println("\n!! An error occurred. !!");
            return false;
        }
        else {

            System.out.println("\n * Checking out basket : " + basket.getName());
            System.out.println(basket);
            for (Map.Entry<StockItem, Integer> item : basketList.entrySet()) {
                stockList.get(item.getKey().getName()).checkout(item.getValue());
            }
            basket.clearBasket();
            return true;
        }
    }
}
