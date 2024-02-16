//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.modelcontroller;

import com.management.schoolmanagement.ConnectionStatus;
import com.management.schoolmanagement.model.Teacher;
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

public class editteachercontroller implements Initializable {
    ConnectionStatus con = new ConnectionStatus();
    @FXML
    TextField id;
    @FXML
    TextField Name;
    @FXML
    TextField Qualification;
    @FXML
    TextField salary;
    @FXML
    TextField leavedate;
    @FXML
    TextField searchid;
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
    @FXML
    Button searchbtn;
    @FXML
    Button delbtn;
    String[] sexopt = new String[]{"Male", "Female", "Others"};
    String[] subopt = new String[]{"All subject", "Math", "Physics", "Chemistry", "Biology", "English", "Hindi", "Geography", "History", "Economics", "Political Science"};
    String[] classopt = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    public editteachercontroller() {
    }

    int search() throws SQLException {
        ArrayList<Teacher> editlist = this.con.RetrieveTeachers();
        long id = Long.parseLong(this.searchid.getText());

        for(int i = 0; i < editlist.size(); ++i) {
            if (id == ((Teacher)editlist.get(i)).getID()) {
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
        ArrayList<Teacher> list = this.con.RetrieveTeachers();
        int i = this.search();
        if (i != -1) {
            this.id.setEditable(true);
            this.Qualification.setEditable(true);
            this.Name.setEditable(true);
            this.Class.setDisable(false);
            this.salary.setEditable(true);
            this.leavedate.setEditable(true);
            this.subject.setDisable(false);
            this.DOB.setEditable(true);
            this.joindate.setEditable(true);
            this.sex.setDisable(false);
            this.id.setText(String.valueOf(((Teacher)list.get(i)).getID()));
            this.Name.setText(((Teacher)list.get(i)).getName().toUpperCase());
            this.DOB.setValue(LOCAL_DATE(((Teacher)list.get(i)).getDOB()));
            this.sex.setValue(((Teacher)list.get(i)).getSex());
            this.Class.setValue(String.valueOf(((Teacher)list.get(i)).getClassTeacher()));
            this.subject.setValue(((Teacher)list.get(i)).getSubject());
            this.Qualification.setText(((Teacher)list.get(i)).getQulification());
            this.salary.setText(String.valueOf(((Teacher)list.get(i)).getSalary()));
            this.joindate.setValue(LOCAL_DATE(((Teacher)list.get(i)).getJoindate()));
            this.leavedate.setText(((Teacher)list.get(i)).getLeaving());
        }

    }

    @FXML
    void setEdit() {
        String ids = this.id.getText();
        long rid = Long.parseLong(ids);
        String cs = (String)this.Class.getValue();
        long c = Long.parseLong(cs);
        String es = this.salary.getText();
        long e = Long.parseLong(es);
        String sid = this.searchid.getText();
        long Sid = Long.parseLong(sid);
        String Dob = ((LocalDate)this.DOB.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String adm = ((LocalDate)this.joindate.getValue()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.con.EditTeachers(rid, this.Name.getText().toUpperCase(), Dob, (String)this.sex.getValue(), c, (String)this.subject.getValue(), this.Qualification.getText(), e, adm, this.leavedate.getText(), Sid);
        Stage stage = (Stage)this.addbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void setDelete() {
        String Sid = this.searchid.getText();
        long sid = Long.parseLong(Sid);
        this.con.DelTeacher(sid);
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
        this.Class.getItems().addAll(this.classopt);
        this.subject.getItems().addAll(this.subopt);
    }
}
