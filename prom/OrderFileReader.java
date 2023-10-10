/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AlphaBeta's
 */
public class OrderFileReader {
     public static ArrayList<Order> readOrdersfromFile(String filename) throws IOException {
        ArrayList<Order> orders = new ArrayList<>();
        Order currentOrder = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Order ID:")) {
                    if (currentOrder != null) {
                        orders.add(currentOrder);
                    }
                    currentOrder = new Order();
                    currentOrder.setOrderId(Integer.parseInt(line.substring("Order ID:".length()).trim()));
                } else if (line.startsWith("User ID:")) {
                    if (currentOrder != null) {
                        currentOrder.setUserId(line.substring("User ID:".length()).trim());
                    }
                } else if (line.startsWith("Items: [")) {
                    if (currentOrder != null) {
                        currentOrder.setItems(new ArrayList<>());
                    }
                    String itemsLine = line.substring("Items: [".length()).trim();
                    // Split and parse the items line into items and prices
                    Pattern pattern = Pattern.compile("([^,]+)-RM(\\d+(?:\\.\\d+)?)");
                    Matcher matcher = pattern.matcher(itemsLine);
                    while (matcher.find()) {
                        String item = matcher.group(1).trim();
                        String price = matcher.group(2).trim();
                        if (currentOrder != null) {
                            currentOrder.getItems().add(item);
                            currentOrder.setTotalPrice(currentOrder.getTotalPrice() + Double.parseDouble(price));
                        }
                    }
                } else if (line.startsWith("Total Price:")) {
                    if (currentOrder != null) {
                        currentOrder.setTotalPrice(Double.parseDouble(line.substring("Total Price:".length()).trim()));
                    }
                } else if (line.startsWith("Date:")) {
                    if (currentOrder != null) {
                        currentOrder.setDate(line.substring("Date:".length()).trim());
                    }
                }
            }

            // Add the last order to the list
            if (currentOrder != null) {
                orders.add(currentOrder);
            }
        }

        return orders;
    }
      }
      
