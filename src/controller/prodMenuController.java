package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Part;
import model.Inventory;
import model.*;

import java.io.IOException;

public class prodMenuController {

    Stage stage;
    Parent scene;

    @FXML
    private TextField prodIDTxt;

    @FXML
    private TextField prodNameTxt;

    @FXML
    private TextField prodPriceTxt;

    @FXML
    private TextField prodStockTxt;

    @FXML
    private TextField prodMaxTxt;

    @FXML
    private TextField prodMinTxt;

    @FXML
    private Button prodSaveBtn;

    @FXML
    private Button prodDeleteBtn;

    @FXML
    private Button prodCancelBtn;

    @FXML
    private TextField prodMenuSearchTxt;

    @FXML
    private TableView<Product> prodTable;

    @FXML
    private Button prodMenuAddPartBtn;

    @FXML
    private TableView<Part> prodMenuPartsTable;


    @FXML
    void onClickAddPartToProd(MouseEvent event) {

    }

    @FXML
    void onClickProdCancel(MouseEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/mainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickProdDelete(MouseEvent event) {


    }

    @FXML
    void onClickProdMenuSearch(MouseEvent event) {

    }

    @FXML
    void onClickSaveProdBtn(MouseEvent event) throws IOException {

        //gets info from text fields and assigns to variable
        int prodID = Integer.parseInt(prodIDTxt.getText());
        String prodName = prodNameTxt.getText();
        int prodStock = Integer.parseInt(prodStockTxt.getText());
        double prodPrice = Double.parseDouble(prodPriceTxt.getText());
        int prodMax = Integer.parseInt(prodMaxTxt.getText());
        int prodMin = Integer.parseInt(prodMinTxt.getText());


        //assigns the input info to each variable and column in table and creates new item in the table.
        Inventory.addProd(new Product(prodID, prodName, prodPrice, prodStock, prodMax, prodMin));


        //After items are saved, this takes user back to main menu
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/mainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }


    public void prodMenuSearchBtn(ActionEvent actionEvent) {
    }


    public void initialize() {
        //sets up table view

    }
}
