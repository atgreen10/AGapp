package controller;

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
    private TableView<?> prodTable;

    @FXML
    private Button prodMenuAddPartBtn;

    @FXML
    private TableView<?> prodMenuPartsListTable;

    @FXML
    void onClickAddPartToProd(MouseEvent event) {

    }

    @FXML
    void onClickProdCancel(MouseEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
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
    void onClickSaveProdBtn(MouseEvent event) {

    }

    @FXML
    void prodMenuSearchBtn(ActionEvent event) {

    }
}
