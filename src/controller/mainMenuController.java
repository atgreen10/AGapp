package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class mainMenuController {

    Stage stage;
    Parent scene;

    @FXML
    private TableView<Part> mainPartTable;

    @FXML
    private TableColumn<Part, Integer> mainTablePartID;

    @FXML
    private TableColumn<Part, String> mainTablePartName;

    @FXML
    private TableColumn<Part, Integer> mainTablePartStock;

    @FXML
    private TableColumn<Part, Double> mainTablePartPrice;

    @FXML
    private TextField mainPartSearchTxt;

    @FXML
    private Button mainSearchPartBtn;

    @FXML
    private Button mainAddPartBtn;

    @FXML
    private Button mainModPartBtn;

    @FXML
    private Button mainDeletePartBtn;

    @FXML
    private TableView<Product> mainProdTable;

    @FXML
    private TableColumn<Product, Integer> mainTableProdID;

    @FXML
    private TableColumn<Product, String> mainTableProdName;

    @FXML
    private TableColumn<Product, Integer> mainTableProdStock;

    @FXML
    private TableColumn<Product, Double> mainTableProdPrice;

    @FXML
    private Button mainProdSearchBtn;

    @FXML
    private Button mainAddProdBtn;

    @FXML
    private Button mainModProdBtn;

    @FXML
    private Button mainDeleteProdBtn;

    @FXML
    private TextField mainProdSearchTxt;

    @FXML
    private Button exitAppBtn;

    @FXML
    void onClickMainAddPartBtn(MouseEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/partMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickMainPartMod(MouseEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.<Parent>load(getClass().getResource("/view/modPartMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickMainAddProdBtn(MouseEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/prodMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickMainDeletePartBtn(MouseEvent event) {

    }

    @FXML
    void onClickMainDeleteProdBtn(MouseEvent event) {

    }

    @FXML
    void onClickMainExitBtn(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void onClickMainModProdBtn(MouseEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/modProdMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickMainSearchPartBtn(MouseEvent event) {
        //searches the part table for matching ID in search term and returns true if found
        searchPart(Integer.parseInt(mainPartSearchTxt.getText()));
    }

    //search parts table with ID
    public boolean searchPart(int partID) {
        for (Part part : Inventory.getAllParts()) {
            if (part.getPartID() == partID) {
                System.out.println("It worked");
                return true;

            }
        }
        return false;
    }

    public boolean Update(int partID, Part part1){
        //related to indexed position of item in table
        int index = -1;
        //searches for already existing part in tbl. If one does exist then we are going to replace it with a new part object.
        for(Part part : Inventory.getAllParts()) {
            index++;
            if (part.getPartID() == partID) {
                Inventory.getAllParts().set(index, part1);
                return true;
            }
        }
        return false;
    }

    //deletes an item with the included partID in parenthesis. then returns the remaining items. Still needs to be attached to page element
    public boolean Delete(int partID){
        for(Part part : Inventory.getAllParts()) {
            if (part.getPartID() == partID) {
                return Inventory.getAllParts().remove(part);
            }
        }
        return false;
    }


    //still needs to be attached to page element
    public Part selectPart(int ID) {
        for (Part part : Inventory.getAllParts()) {
            if (part.getPartID() == ID) {
                return part;
            }
        }
        return null;
    }


    public void initialize(){
        //sets up table view
        mainPartTable.setItems(Inventory.getAllParts());

        //Describes where the columns get their info.
        mainTablePartID.setCellValueFactory(new PropertyValueFactory<>("partID"));
        mainTablePartName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        mainTablePartPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        mainTablePartStock.setCellValueFactory(new PropertyValueFactory<>("partStock"));


        //Sets up product table.
        mainProdTable.setItems(Inventory.getAllProducts());
        //describes product table on main page.
        mainTableProdID.setCellValueFactory(new PropertyValueFactory<>("prodID"));
        mainTableProdName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        mainTableProdPrice.setCellValueFactory(new PropertyValueFactory<>("prodPrice"));
        mainTableProdStock.setCellValueFactory(new PropertyValueFactory<>("prodStock"));


       /* if(Update(2, (new InHouse(13, "RX5700 XT", 450.00, 11, 31, 1, 625,true)))){
            System.out.println("Successful update");

        }
        else {
            System.out.println("Update failed");
        }
        if(Delete(2)){
            System.out.println("Deleted");
        }
        else {
            System.out.println("Not Found");
        }*/

        mainPartTable.getSelectionModel().select(selectPart(1));

    }

}