//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.modelcontroller;

import com.management.schoolmanagement.ConnectionStatus;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class addScienceLab implements Initializable {
    ConnectionStatus con = new ConnectionStatus();
    @FXML
    TextField id;
    @FXML
    TextField Name;
    @FXML
    Button closebtn;
    @FXML
    Button addbtn;

    public addScienceLab() {
    }

    @FXML
    void addEquipment() {
        try {
            this.con.InsertSciLabEquipment(Long.parseLong(this.id.getText()), this.Name.getText());
            Stage stage = (Stage)this.addbtn.getScene().getWindow();
            stage.close();
        } catch (Exception var2) {
            System.out.println("enter proper data");
        }

    }

    @FXML
    void close() {
        Stage stage = (Stage)this.closebtn.getScene().getWindow();
        stage.close();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    id.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
