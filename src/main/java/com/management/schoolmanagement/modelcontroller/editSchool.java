//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.modelcontroller;

import com.management.schoolmanagement.ConnectionStatus;
import com.management.schoolmanagement.model.School;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editSchool implements Initializable {
    ConnectionStatus con = new ConnectionStatus();
    @FXML
    TextField id;
    @FXML
    TextField Name;
    @FXML
    TextField address;
    @FXML
    TextField pname;
    @FXML
    DatePicker odate;
    @FXML
    Button closebtn;
    @FXML
    Button addbtn;

    public editSchool(){
    }

    @FXML
    void editSchool() throws SQLException {
        ArrayList<School> list = this.con.RetrieveSchool();
        long sid = ((School)list.get(0)).getId();
        String date = ((LocalDate)this.odate.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.con.EditSchool(Long.parseLong(this.id.getText()), this.Name.getText(), this.address.getText(), date, this.pname.getText(), sid);
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
