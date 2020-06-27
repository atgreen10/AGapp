package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class modPartController {

    Stage stage;
    Parent scene;

    @FXML
    private RadioButton inHouseBtn;

    @FXML
    private RadioButton outsourcedBtn;

    @FXML
    private Label modPartSourceLabel;

    @FXML
    private TextField modPartID;

    @FXML
    private TextField modPartName;

    @FXML
    private TextField modPartStock;

    @FXML
    private TextField modPartPrice;

    @FXML
    private TextField modPartMax;

    @FXML
    private TextField modPartSourceTxt;

    @FXML
    private TextField modPartMin;

    @FXML
    private Button modPartCancelBtn;

    @FXML
    void onClickModPartCancel(MouseEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/mainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
