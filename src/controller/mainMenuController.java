package controller;

import javafx.beans.binding.ObjectExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.util.Optional;


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
    private ObservableList<Part> partSearchList = FXCollections.observableArrayList();

    @FXML private ObservableList<Product> productSearchList = FXCollections.observableArrayList();


    @FXML
    void onClickMainAddPartBtn(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/partMenu.fxml"));
        loader.load();
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickMainPartMod(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/modPartMenu.fxml"));
        loader.load();

        modPartController modPartCtrl = loader.getController();
        modPartCtrl.sendPart(mainPartTable.getSelectionModel().getSelectedItem());

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
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
    void onClickPartSearch(MouseEvent event) {

       if(!mainPartSearchTxt.getText().isEmpty()){
           partSearchList.clear();
           for(Part part : Inventory.getAllParts()){
               if(part.getPartName().contains(mainPartSearchTxt.getText())){
                   partSearchList.add(part);
               }
               if(mainPartSearchTxt.getText().contains(String.valueOf(part.getPartID()))){
                   partSearchList.add(part);
               }
           }
           mainPartTable.setItems(partSearchList);
           mainPartTable.refresh();
       }
       else{
           mainPartTable.refresh();
       }
    }

    @FXML
    void onClickMainDeletePartBtn(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this part?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            Part selectPart = mainPartTable.getSelectionModel().getSelectedItem();
            Inventory.deletePart(selectPart);
        }

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


    public void initialize() {
        //sets up table view with regular default view
        mainPartTable.setItems(Inventory.getAllParts());


        //Describes where the columns get their info.
        mainTablePartID.setCellValueFactory(new PropertyValueFactory<>("partID"));
        mainTablePartName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        mainTablePartPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        mainTablePartStock.setCellValueFactory(new PropertyValueFactory<>("partStock"));

       /* if(searchPart(33)){
            System.out.println("match");
        }
        else{
            System.out.println("No match");
        }

        if (updatePart(2, new InHouse(2, "NewPart", 49.99, 20, 10, 1, 200, true))) {
            System.out.println("Update Successful");
        } else{
            System.out.println("update failed");
        }

        if(deletePart(3)){
            System.out.println("Deleted Part");
        }
        else{
            System.out.println("No Match!");
        }*/

       // mainPartTable.getSelectionModel().select(selectPart(2));



    }

}
