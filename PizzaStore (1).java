package com.example.demo;


public class PizzaStore {


    private final String[][] userInfo = {{"Baskin", "100 Chambers"}};
    private final String[] itemNames = {"Pepperoni", "Cheese", "Veggie", "House Special"};
    private final double[] itemPrices = {12.99, 10.99, 9.99, 14.99};
    private final double taxRate = 0.08;
    private final double Total = 0;

    public double getTotal() {
        return Total;
    }

    public static double setTotal(double total) {
        return total;
    }

    public String getUsername() {
        return userInfo[0][0];
    }


    public String getPassword() {
        return userInfo[0][1];
    }

    // Method to return the price of an item given its name and ignore lower and upper cases
    public double getPrice(String itemName) {
        for (int i = 0; i < itemNames.length; i++) {
            if (itemNames[i].equalsIgnoreCase(itemName)) {
                return itemPrices[i];
            }
        }
        return -1.0;
    }


    public String[] getItemNames() {
        return itemNames;
    }

    // Method to calculate the cost of items given their quantities
    public double calculateCost(int[] quantities) {
        double totalCost = 0.0;
        for (int i = 0; i < itemPrices.length; i++) {
            totalCost += itemPrices[i] * quantities[i];
        }
        return totalCost;
    }


    public double calculateTaxes(double cost) {
        return cost * taxRate;
    }


    public double calculateTotalCost(int[] quantities) {
        double cost = calculateCost(quantities);
        double taxes = calculateTaxes(cost);
        return cost + taxes;
    }

}
