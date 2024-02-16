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

public class addteachercontroller implements Initializable {
    ConnectionStatus con = new ConnectionStatus();
    @FXML
    TextField id;
    @FXML
    TextField Name;
    @FXML
    TextField qualification;
    @FXML
    TextField salary;
    @FXML
    TextField leavedate;
    @FXML
    DatePicker DOB;
    @FXML
    DatePicker joindate;
    @FXML
    ChoiceBox<String> sex;
    @FXML
    ChoiceBox<String> Class;
    @FXML
    ChoiceBox<String> subject;
    @FXML
    Button closebtn;
    @FXML
    Button addbtn;
    String[] sexopt = new String[]{"Male", "Female", "Others"};
    String[] subopt = new String[]{"All subject", "Math", "Physics", "Chemistry", "Biology", "English", "Hindi", "Geography", "History", "Economics", "Political Science"};
    String[] classopt = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    public addteachercontroller() {
    }

    @FXML
    void add_student() {
        try {
            String ids = this.id.getText();
            long rid = Long.parseLong(ids);
            String es = this.salary.getText();
            long e = Long.parseLong(es);
            String cs = (String)this.Class.getValue();
            long c = Long.parseLong(cs);
            String Dob = ((LocalDate)this.DOB.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String adm = ((LocalDate)this.joindate.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.con.InsertTeachers(rid, this.Name.getText().toUpperCase(), Dob, (String)this.sex.getValue(), c, (String)this.subject.getValue(), this.qualification.getText(), e, adm, this.leavedate.getText());
            Stage stage = (Stage)this.addbtn.getScene().getWindow();
            stage.close();
        } catch (Exception var13) {
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
        salary.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    salary.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        this.sex.getItems().addAll(this.sexopt);
        this.sex.setValue("Male");
        this.Class.getItems().addAll(this.classopt);
        this.Class.setValue("0");
        this.subject.getItems().addAll(this.subopt);
        this.subject.setValue("All subject");
    }
}
