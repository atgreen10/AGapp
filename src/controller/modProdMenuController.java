package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class modProdMenuController {
    Stage stage;
    Parent scene;

    @FXML
    private TextField modProdIDTxt;

    @FXML
    private TextField modProdNameTxt;

    @FXML
    private TextField modProdPriceTxt;

    @FXML
    private TextField modProdStockTxt;

    @FXML
    private TextField modProdMaxTxt;

    @FXML
    private TextField modProdMinTxt;

    @FXML
    private Button modProdSaveBtn;

    @FXML
    private Button modProdDeletePartBtn;

    @FXML
    private Button modProdCancelBtn;

    @FXML
    private Button modProdSearchBtn;

    @FXML
    private TextField modProdSearchTxt;

    @FXML
    private TableView<?> modProdAllPartsTable;

    @FXML
    private Button modProdAddPartBtn;

    @FXML
    private TableView<?> modProdIncludedPartsTable;

    @FXML
    void onClickModProdAddBtn(MouseEvent event) {

    }

    @FXML
    void onClickModProdCancelBtn(MouseEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/mainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onClickModProdSaveBtn(MouseEvent event) {

    }

    @FXML
    void onClickModProdSearchBtn(MouseEvent event) {

    }

    @FXML
    void onClicklModProdDeletePartBtn(MouseEvent event) {

    }
}
