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
import java.net.URL;
import java.util.ResourceBundle;

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
    private Button mainPartSearchBtn;

    @FXML
    private Button mainAddPartBtn;

    @FXML
    private Button mainModPartBtn;

    @FXML
    private Button mainDeletePartBtn;

    @FXML
    private TextField mainPartSearchTxt;

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
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/partMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickMainPartMod(MouseEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.<Parent>load(getClass().getResource("/view/modPartMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickMainAddProdBtn(MouseEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
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
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/modProdMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

   /* public boolean mainPartSearchRequest(int partID) {
        for (Part part : Inventory.getAllParts()) {
            if (part.getPartID() == partID)
                return true;
        }
        return false;
    }

    public boolean update(int ID, Part part){
        int index = -1;

        for(Part InHouse : Inventory.getAllParts()){
            index++;

            if(part.getPartID() == ID);
        }
    }
*/


        public void initialize() {
            //sets up table view
            mainPartTable.setItems(Inventory.getAllParts());

            //Describes where the columns get their info.
            mainTablePartID.setCellValueFactory(new PropertyValueFactory<>("partID"));
            mainTablePartName.setCellValueFactory(new PropertyValueFactory<>("partName"));
            mainTablePartPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
            mainTablePartStock.setCellValueFactory(new PropertyValueFactory<>("partStock"));




   /* if (mainPartSearchRequest(3)){
        System.out.println("found");
    }
    else{
        System.out.println("Error");
     }*/



        mainProdTable.setItems(Inventory.getAllProducts());

        mainTableProdID.setCellValueFactory(new PropertyValueFactory<>("prodID"));
        mainTableProdName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        mainTableProdPrice.setCellValueFactory(new PropertyValueFactory<>("prodPrice"));
        mainTableProdStock.setCellValueFactory(new PropertyValueFactory<>("prodStock"));

      //  String mainProdSearchRequest;





    }


}
