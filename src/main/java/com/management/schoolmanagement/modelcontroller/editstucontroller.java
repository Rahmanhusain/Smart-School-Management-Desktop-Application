//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.modelcontroller;

import com.management.schoolmanagement.ConnectionStatus;
import com.management.schoolmanagement.model.Student;
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
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editstucontroller implements Initializable {
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
    TextField searchid;
    @FXML
    DatePicker DOB;
    @FXML
    DatePicker admmdate;
    @FXML
    ChoiceBox<String> sex;
    @FXML
    ChoiceBox<String> Class;
    @FXML
    ChoiceBox<String> sec;
    @FXML
    ChoiceBox<String> status;
    @FXML
    Button closebtn;
    @FXML
    Button addbtn;
    @FXML
    Button searchbtn;
    @FXML
    Button delbtn;
    String[] sexopt = new String[]{"Male", "Female", "Others"};
    String[] statusopt = new String[]{"Studying", "Ex Student"};
    String[] secopt = new String[]{"A", "B", "C", "D", "E"};
    String[] classopt = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    public editstucontroller() {
    }

    int search() throws SQLException {
        ArrayList<Student> editlist = this.con.RetrieveStudent();
        long id = Long.parseLong(this.searchid.getText());

        for(int i = 0; i < editlist.size(); ++i) {
            if (id == ((Student)editlist.get(i)).getRoll_no()) {
                return i;
            }
        }

        return -1;
    }

    public static final LocalDate LOCAL_DATE(String d) {
        DateTimeFormatter D = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(d, D);
    }

    @FXML
    void setSearchbtn() throws SQLException {
        ArrayList<Student> list = this.con.RetrieveStudent();
        int i = this.search();
        if (i != -1) {
            this.id.setEditable(true);
            this.leaving.setEditable(true);
            this.Name.setEditable(true);
            this.Class.setDisable(false);
            this.sec.setDisable(false);
            this.father.setEditable(true);
            this.mother.setEditable(true);
            this.enroll.setEditable(true);
            this.Fee.setEditable(true);
            this.DOB.setEditable(true);
            this.admmdate.setEditable(true);
            this.sex.setDisable(false);
            this.status.setDisable(false);
            this.id.setText(String.valueOf(((Student)list.get(i)).getRoll_no()));
            this.Name.setText(((Student)list.get(i)).getName().toUpperCase());
            this.Class.setValue(String.valueOf(((Student)list.get(i)).getClasses()));
            this.sec.setValue(((Student)list.get(i)).getSec());
            this.father.setText(((Student)list.get(i)).getFather().toUpperCase());
            this.mother.setText(((Student)list.get(i)).getMother().toUpperCase());
            this.enroll.setText(String.valueOf(((Student)list.get(i)).getEnroll()));
            this.Fee.setText(String.valueOf(((Student)list.get(i)).getFee()));
            this.leaving.setText(((Student)list.get(i)).getLeaving());
            this.DOB.setValue(LOCAL_DATE(((Student)list.get(i)).getDOB()));
            this.admmdate.setValue(LOCAL_DATE(((Student)list.get(i)).getAdmission()));
            this.sex.setValue(((Student)list.get(i)).getSex());
            this.status.setValue(((Student)list.get(i)).getStatus());
        }

    }

    @FXML
    void setEdit() {
        String ids = this.id.getText();
        long rid = Long.parseLong(ids);
        String cs = (String)this.Class.getValue();
        long c = Long.parseLong(cs);
        String es = this.enroll.getText();
        long e = Long.parseLong(es);
        String Fs = this.Fee.getText();
        long F = Long.parseLong(Fs);
        String Sid = this.searchid.getText();
        long sid = Long.parseLong(Sid);
        String Dob = ((LocalDate)this.DOB.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String adm = ((LocalDate)this.admmdate.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.con.EditStudent(rid, this.Name.getText().toUpperCase(), Dob, (String)this.sex.getValue(), c, (String)this.sec.getValue(), this.father.getText().toUpperCase(), this.mother.getText().toUpperCase(), e, adm, F, (String)this.status.getValue(), this.leaving.getText(), sid);
        Stage stage = (Stage)this.addbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void setDelete() {
        String Sid = this.searchid.getText();
        long sid = Long.parseLong(Sid);
        this.con.Delstudent(sid);
        Stage stage = (Stage)this.delbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void close() {
        Stage stage = (Stage)this.closebtn.getScene().getWindow();
        stage.close();
    }

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
