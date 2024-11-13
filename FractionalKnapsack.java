package java_pr;

import java.util.Arrays;

public class FractionalKnapsack {

    // Function to get the maximum value in the knapsack
    public static double getMaxValue(int[] values, int[] weights, int capacity) {
        int n = values.length;
        
        // Array to store value-to-weight ratios
        double[] ratios = new double[n];
        
        // Fill ratios array with value/weight for each item
        for (int i = 0; i < n; i++) {
            ratios[i] = (double) values[i] / weights[i];
        }
        
        // Sort items based on their value-to-weight ratio using basic selection sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratios[i] < ratios[j]) {
                    // Swap ratios
                    double tempRatio = ratios[i];
                    ratios[i] = ratios[j];
                    ratios[j] = tempRatio;

                    // Swap corresponding values
                    int tempValue = values[i];
                    values[i] = values[j];
                    values[j] = tempValue;

                    // Swap corresponding weights
                    int tempWeight = weights[i];
                    weights[i] = weights[j];
                    weights[j] = tempWeight;
                }
            }
        }

        double totalValue = 0.0;

        // Iterate through the sorted arrays to fill the knapsack
        for (int i = 0; i < n; i++) {
            if (capacity == 0) break; // Knapsack is full

            if (weights[i] <= capacity) {
                // Take the full item
                totalValue += values[i];
                capacity -= weights[i];
                System.out.println("Taking full item with weight: " + weights[i] + " and value: " + values[i]);
            } else {
                // Take a fraction of the item
                double fraction = (double) capacity / weights[i];
                totalValue += values[i] * fraction;
                System.out.println("Taking fraction " + fraction + " of item with weight: " + weights[i] + " and value: " + values[i]);
                capacity = 0; // Knapsack is now full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Example values and weights arrays
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        // Calculate and print the maximum value
        double maxValue = getMaxValue(values, weights, capacity);
        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
