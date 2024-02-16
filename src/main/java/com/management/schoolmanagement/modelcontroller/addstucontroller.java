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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class addstucontroller implements Initializable {
    ConnectionStatus con = new ConnectionStatus();
    @FXML
    TextField id;
    @FXML
    TextField Name;
    @FXML
    TextField father;
    @FXML
    TextField mother;
    @FXML
    TextField enroll;
    @FXML
    TextField Fee;
    @FXML
    TextField leaving;
    @FXML
    DatePicker DOB;
    @FXML
    DatePicker admmdate;
    @FXML
    ChoiceBox<String> sex;
    @FXML
    ChoiceBox<String> status;
    @FXML
    ChoiceBox<String> sec;
    @FXML
    ChoiceBox<String> Class;
    @FXML
    Button closebtn;
    @FXML
    Button addbtn;
    String[] sexopt = new String[]{"Male", "Female", "Others"};
    String[] statusopt = new String[]{"Studying", "Ex Student"};
    String[] secopt = new String[]{"A", "B", "C", "D", "E"};
    String[] classopt = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    public addstucontroller() {
    }

    @FXML
    void add_student() {
        try {
            String ids = this.id.getText();
            long rid = Long.parseLong(ids);
            String es = this.enroll.getText();
            long e = Long.parseLong(es);
            String cs = (String)this.Class.getValue();
            long c = Long.parseLong(cs);
            String Fs = this.Fee.getText();
            long F = Long.parseLong(Fs);
            String Dob = ((LocalDate)this.DOB.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String adm = ((LocalDate)this.admmdate.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.con.InsertStudent(rid, this.Name.getText().toUpperCase(), Dob, (String)this.sex.getValue(), c, (String)this.sec.getValue(), this.father.getText().toUpperCase(), this.mother.getText().toUpperCase(), e, adm, F, (String)this.status.getValue(), this.leaving.getText());
            Stage stage = (Stage)this.addbtn.getScene().getWindow();
            stage.close();
        } catch (Exception var16) {
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
        enroll.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    enroll.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        Fee.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    Fee.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        this.sex.getItems().addAll(this.sexopt);
        this.sex.setValue("Male");
        this.status.getItems().addAll(this.statusopt);
        this.status.setValue("Studying");
        this.Class.getItems().addAll(this.classopt);
        this.Class.setValue("1");
        this.sec.getItems().addAll(this.secopt);
        this.sec.setValue("A");
    }
}
