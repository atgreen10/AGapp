package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    public static void addPart(Part part) {
        allParts.add(part);
    }

    public static ObservableList<Part> getAllParts() {
        System.out.println(allParts);
        return allParts;
    }
}
   /* private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public static void addProd(Product product) {
        allProducts.add(product);
    }

    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }

}*/
