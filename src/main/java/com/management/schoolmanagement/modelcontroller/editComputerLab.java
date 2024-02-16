//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.modelcontroller;

import com.management.schoolmanagement.ConnectionStatus;
import com.management.schoolmanagement.model.ComputerLab;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editComputerLab implements Initializable {
    ConnectionStatus con = new ConnectionStatus();
    @FXML
    TextField id;
    @FXML
    TextField Name;
    @FXML
    TextField status;
    @FXML
    TextField searchid;
    @FXML
    Button closebtn;
    @FXML
    Button addbtn;
    @FXML
    Button searchbtn;
    @FXML
    Button delbtn;

    public editComputerLab() {
    }

    int search() throws SQLException {
        ArrayList<ComputerLab> editlist = this.con.RetrieveCompputer();
        long id = Long.parseLong(this.searchid.getText());

        for(int i = 0; i < editlist.size(); ++i) {
            if (id == ((ComputerLab)editlist.get(i)).getID()) {
                return i;
            }
        }

        return -1;
    }

    @FXML
    void setEdit() {
        this.con.EditComputer(Long.parseLong(this.id.getText()), this.Name.getText(), this.status.getText(), Long.parseLong(this.searchid.getText()));
        Stage stage = (Stage)this.addbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void close() {
        Stage stage = (Stage)this.closebtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void setSearchbtn() throws SQLException {
        ArrayList<ComputerLab> list = this.con.RetrieveCompputer();
        int i = this.search();
        if (i != -1) {
            this.id.setEditable(true);
            this.Name.setEditable(true);
            this.status.setEditable(true);
            this.id.setText(String.valueOf(((ComputerLab)list.get(i)).getID()));
            this.Name.setText(((ComputerLab)list.get(i)).getName());
            this.status.setText(((ComputerLab)list.get(i)).getStatus());
        }

    }

    @FXML
    void setDelete() {
        this.con.DelComputer(Long.parseLong(this.searchid.getText()));
        Stage stage = (Stage)this.delbtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchid.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    searchid.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
