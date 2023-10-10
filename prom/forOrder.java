/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prom;

import java.util.ArrayList;
import javaapplication.Customer_Login;

/**
 *
 * @author AlphaBeta's
 */
public class forOrder {
    private String formattedDate; 
    private int orderId;
    private ArrayList<String> items;
    private double totaPrice;
   

   
    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the userId
     */
    /**
     * @return the items
     */
    public ArrayList<String> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    /**
     * @return the totaPrice
     */
    public double getTotaPrice() {
        return totaPrice;
    }

    /**
     * @param totaPrice the totaPrice to set
     */
    public void setTotaPrice(double totaPrice) {
        this.totaPrice = totaPrice;
    }

    public forOrder(String formattedDate,int orderId, ArrayList<String> items, double totaPrice) {
        this.formattedDate = formattedDate;
        this.orderId = orderId;
        this.items = items;
        this.totaPrice = totaPrice;
    }

    @Override
    public String toString() {
        return "forOrder{" + "formattedDate=" + formattedDate + ", orderId=" + orderId + ", items=" + items + ", totaPrice=" + totaPrice + '}';
    }

     /**
     * @return the formattedDate
     */
    public String getFormattedDate() {
        return formattedDate;
    }

    /**
     * @param formattedDate the formattedDate to set
     */
    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }
}
