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
import model.InHouse;
import model.Inventory;
import model.Outsource;
import model.Part;

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

    public void sendPart(Part part) {
        modPartID.setText(String.valueOf(part.getPartID()));
        modPartName.setText(part.getPartName());
        modPartStock.setText(String.valueOf(part.getPartStock()));
        modPartPrice.setText(String.valueOf(part.getPartPrice()));
        modPartMax.setText(String.valueOf(part.getPartMax()));
        modPartMin.setText(String.valueOf(part.getPartMin()));

        if (part instanceof InHouse) {
            inHouseBtn.setSelected(true);
            modPartSourceTxt.setText(String.valueOf(((InHouse) part).getMachineID()));

        } else {
            outsourcedBtn.setSelected(true);
            modPartSourceTxt.setText(((Outsource) part).getCompanyName());
        }
    }


    @FXML
    void onClickSavePartMods(MouseEvent event) throws IOException{

        int updatedPartID;
        String updatedPartName;
        int partStock;
        double partPrice;
        int partMax;
        int partMin;

        if(inHouseBtn.isSelected()){
            updatedPartID = Integer.parseInt(modPartID.getText());
            updatedPartName = modPartName.getText();
            partStock = Integer.parseInt(modPartStock.getText());
            partPrice = Double.parseDouble(modPartPrice.getText());
            partMax = Integer.parseInt(modPartMax.getText());
            partMin = Integer.parseInt(modPartMin.getText());
            int machineID = Integer.parseInt(modPartSourceTxt.getText());

            Inventory.updatePart(new InHouse(updatedPartID, updatedPartName, partPrice, partStock, partMax, partMin, machineID));
        }

        else if(outsourcedBtn.isSelected()) {

            updatedPartID = Integer.parseInt(modPartID.getText());
            updatedPartName = modPartName.getText();
            partStock = Integer.parseInt(modPartStock.getText());
            partPrice = Double.parseDouble(modPartPrice.getText());
            partMax = Integer.parseInt(modPartMax.getText());
            partMin = Integer.parseInt(modPartMin.getText());
            String companyName = modPartSourceTxt.getText();

            Inventory.updatePart(new Outsource(updatedPartID, updatedPartName, partPrice, partStock, partMax, partMin, companyName));
        }

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/mainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
