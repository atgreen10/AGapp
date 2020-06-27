package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsource;
import model.Part;

import java.io.IOException;

public class partMenuController {

    Stage stage;
    Parent scene;

    @FXML
    private Label partSourceTitle;

    @FXML
    private RadioButton inHouseBtn;

    @FXML
    private ToggleGroup partSourceToggle;

    @FXML
    private TextField partSourceTxt;

    @FXML
    private RadioButton outSourcedBtn;

    @FXML
    private TextField partIDTxt;

    @FXML
    private TextField partNameTxt;

    @FXML
    private TextField partStockTxt;

    @FXML
    private TextField partPriceTxt;

    @FXML
    private TextField partMaxTxt;

    @FXML
    private TextField partMinTxt;

    @FXML
    private Button partMenuSaveBtn;

    @FXML
    private Button partMenuCancelBtn;

    @FXML
    void onClickPartMenuCancel(MouseEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/mainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML void onClickSavePartBtn(MouseEvent event) throws IOException {
        //gets info from text fields and saves to local variable.

        int partID = Integer.parseInt(partIDTxt.getText());
        String partName = partNameTxt.getText();
        int partStock = Integer.parseInt(partStockTxt.getText());
        double partPrice = Double.parseDouble(partPriceTxt.getText());
        int partMax = Integer.parseInt(partMaxTxt.getText());
        int partMin = Integer.parseInt(partMinTxt.getText());
        boolean sourcedInHouse = false;

        if(inHouseBtn.isSelected()){
            partSourceTitle.setText("Machine TD");
            int machineID = Integer.parseInt(partSourceTxt.getText());
            Inventory.addPart(new InHouse(partID, partName, partPrice, partStock, partMax, partMin, machineID, true));
        }

       else if(outSourcedBtn.isSelected()) {
            partSourceTitle.setText("Company Name");
            String companyName = partSourceTxt.getText();
            Inventory.addPart(new Outsource(partID, partName, partPrice, partStock, partMax, partMin, companyName, false));
        }

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/mainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

        }
    }
