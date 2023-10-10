/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prom;

import java.io.Serializable;
/**
 *
 * @author AlphaBeta's
 */
public class Orders implements Serializable{
    private double Itemprice;
    private String itemName;

    public Orders(double Itemprice, String itemName) {
        this.Itemprice = Itemprice;
        this.itemName = itemName;
    }
    
       /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return the Itemprice
     */
    public double getItemprice() {
        return Itemprice;
    }

}
