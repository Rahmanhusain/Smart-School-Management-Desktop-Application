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

public class editFee implements Initializable {
    ConnectionStatus con = new ConnectionStatus();
    @FXML
    TextField Class;
    @FXML
    TextField fee;
    @FXML
    Button closebtn;
    @FXML
    Button addbtn;

    public editFee() {
    }

    @FXML
    void editFee() {
        this.con.Editfee(this.Class.getText(), Long.parseLong(this.fee.getText()), this.Class.getText());
        Stage stage = (Stage)this.addbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void close() {
        Stage stage = (Stage)this.closebtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fee.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    fee.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
