package model;

import javafx.collections.ObservableList;

public class Product {
    private int prodID, prodStock, prodMin, prodMax;
    private String prodName;
    private double prodPrice;
    private ObservableList<Product> associatedParts;

    public Product(int prodID, String prodName, double prodPrice, int prodStock, int prodMax, int prodMin){
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodStock = prodStock;
        this.prodMax = prodMax;
        this.prodMin = prodMin;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public int getProdStock() {
        return prodStock;
    }

    public void setProdStock(int prodStock) {
        this.prodStock = prodStock;
    }

    public int getProdMin() {
        return prodMin;
    }

    public void setProdMin(int prodMin) {
        this.prodMin = prodMin;
    }

    public int getProdMax() {
        return prodMax;
    }

    public void setProdMax(int prodMax) {
        this.prodMax = prodMax;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }
}
