//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import com.management.schoolmanagement.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class Student_login {
    ObservableList<Student> list = FXCollections.observableArrayList();
    ConnectionStatus c = new ConnectionStatus();
    ArrayList<Student> List = new ArrayList<>();
    @FXML
    private TableView<Student> Studenttblview;
    @FXML
    private TableColumn<Student, Long> Fee;
    @FXML
    private TableColumn<Student, Long> Roll;
    @FXML
    private TableColumn<Student, String> admi;
    @FXML
    private TableColumn<Student, Long> Class;
    @FXML
    private TableColumn<Student, String> dob;
    @FXML
    private TableColumn<Student, Long> enroll;
    @FXML
    private TableColumn<Student, String> father;
    @FXML
    private TableColumn<Student, String> leave;
    @FXML
    private TableColumn<Student, String> mother;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> sec;
    @FXML
    private TableColumn<Student, String> sex;
    @FXML
    private TableColumn<Student, String> status;
    @FXML
    private TextField searchbox;

    public Student_login() {
    }

    @FXML
    protected void SearchStudent() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Studenttblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveStudent();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                if (searchbox.getText().equals(String.valueOf(List.get(i).getRoll_no()))||searchbox.getText().toUpperCase().equals(List.get(i).getName())) {
                    this.list.add(new Student(this.List.get(i).getRoll_no(), this.List.get(i).getName(), this.List.get(i).getDOB(), this.List.get(i).getSex(), this.List.get(i).getClasses(), this.List.get(i).getSec(), this.List.get(i).getFather(), this.List.get(i).getMother(), this.List.get(i).getEnroll(), this.List.get(i).getAdmission(), this.List.get(i).getFee(), this.List.get(i).getStatus(), this.List.get(i).getLeaving()));
                }
                }

            this.Roll.setCellValueFactory(new PropertyValueFactory<>("Roll_no"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            this.dob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
            this.sex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
            this.Class.setCellValueFactory(new PropertyValueFactory<>("Classes"));
            this.sec.setCellValueFactory(new PropertyValueFactory<>("sec"));
            this.father.setCellValueFactory(new PropertyValueFactory<>("father"));
            this.mother.setCellValueFactory(new PropertyValueFactory<>("mother"));
            this.enroll.setCellValueFactory(new PropertyValueFactory<>("Enroll"));
            this.admi.setCellValueFactory(new PropertyValueFactory<>("Admission"));
            this.Fee.setCellValueFactory(new PropertyValueFactory<>("Fee"));
            this.status.setCellValueFactory(new PropertyValueFactory<>("Status"));
            this.leave.setCellValueFactory(new PropertyValueFactory<>("leaving"));
            this.Studenttblview.setItems(this.list);
        }

    }
}
