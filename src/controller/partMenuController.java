package controller;


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
    private RadioButton inHouseBtn;

    @FXML
    private ToggleGroup partSourceToggle;

    @FXML
    private Text partSourceTitle;

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

        //gets info from text fields and assigns to variable
        int partID = Integer.parseInt(partIDTxt.getText());
        String partName = partNameTxt.getText();
        int partStock = Integer.parseInt(partStockTxt.getText());
        double partPrice = Double.parseDouble(partPriceTxt.getText());
        int partMax = Integer.parseInt(partMaxTxt.getText());
        int partMin = Integer.parseInt(partMinTxt.getText());
        boolean sourcedInHouse;

        //assigns the input info to each variable and column in table and creates new item in the table.
        if(inHouseBtn.isSelected()){
            int machineID = Integer.parseInt(partSourceTxt.getText());
            Inventory.addPart(new InHouse(partID, partName, partPrice, partStock, partMax, partMin, machineID, true));
        }
        else if(outSourcedBtn.isSelected()){
            String companyName = partSourceTxt.getText();
            Inventory.addPart(new Outsource(partID, partName, partPrice, partStock, partMax, partMin, companyName, false));
        }

        //After items are saved, this takes user back to main menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/mainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onClickInHouseBtn(MouseEvent event) {
        partSourceTitle.setVisible(true);
        partSourceTxt.setVisible(true);
        partSourceTitle.setText("Machine ID");
    }

    @FXML
    void onClickOutSourcedBtn(MouseEvent event) {
        partSourceTitle.setVisible(true);
        partSourceTxt.setVisible(true);
        partSourceTitle.setText("Company Name");

    }

}

