//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import com.management.schoolmanagement.model.Student;
import com.management.schoolmanagement.model.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Teachercontroller implements Initializable {
    ObservableList<Teacher> list = FXCollections.observableArrayList();
    ConnectionStatus c = new ConnectionStatus();
    ArrayList<Teacher> List = new ArrayList<>();
    @FXML
    private TableView<Teacher> Teachertblview;
    @FXML
    private TableColumn<Student, Long> Id;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> dob;
    @FXML
    private TableColumn<Student, String> sex;
    @FXML
    private TableColumn<Student, String> subject;
    @FXML
    private TableColumn<Student, Long> classteacher;
    @FXML
    private TableColumn<Student, String> qualification;
    @FXML
    private TableColumn<Student, Long> salary;
    @FXML
    private TableColumn<Student, String> joindate;
    @FXML
    private TableColumn<Student, String> leave;
    @FXML
    private TextField searchbox;

    public Teachercontroller() {
    }

    @FXML
    protected void AddTeacher() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Add Teacher");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/add_teachers.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    protected void EditTeachers() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Edit Students");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/edit_teachers.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    protected void AllTeachers() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Teachertblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveTeachers();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new Teacher(this.List.get(i).getID(), this.List.get(i).getName(), this.List.get(i).getDOB(), this.List.get(i).getSex(), this.List.get(i).getClassTeacher(), this.List.get(i).getSubject(), this.List.get(i).getQulification(), this.List.get(i).getSalary(), this.List.get(i).getJoindate(), this.List.get(i).getLeaving()));
            }

            this.Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            this.dob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
            this.sex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
            this.classteacher.setCellValueFactory(new PropertyValueFactory<>("ClassTeacher"));
            this.subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
            this.qualification.setCellValueFactory(new PropertyValueFactory<>("Qulification"));
            this.salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            this.joindate.setCellValueFactory(new PropertyValueFactory<>("joindate"));
            this.leave.setCellValueFactory(new PropertyValueFactory<>("leaving"));
            this.Teachertblview.setItems(this.list);
        }

    }

    @FXML
    protected void SearchTeacher() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Teachertblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveTeachers();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                if (searchbox.getText().equals(String.valueOf(List.get(i).getID()))||searchbox.getText().toUpperCase().equals(List.get(i).getName())) {
                    this.list.add(new Teacher(this.List.get(i).getID(), this.List.get(i).getName(), this.List.get(i).getDOB(), this.List.get(i).getSex(), this.List.get(i).getClassTeacher(), this.List.get(i).getSubject(), this.List.get(i).getQulification(), this.List.get(i).getSalary(), this.List.get(i).getJoindate(), this.List.get(i).getLeaving()));
                }
                }

            this.Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            this.dob.setCellValueFactory(new PropertyValueFactory<>("DOB"));
            this.sex.setCellValueFactory(new PropertyValueFactory<>("Sex"));
            this.classteacher.setCellValueFactory(new PropertyValueFactory<>("ClassTeacher"));
            this.subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
            this.qualification.setCellValueFactory(new PropertyValueFactory<>("Qulification"));
            this.salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            this.joindate.setCellValueFactory(new PropertyValueFactory<>("joindate"));
            this.leave.setCellValueFactory(new PropertyValueFactory<>("leaving"));
            this.Teachertblview.setItems(this.list);
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.AllTeachers();
    }
}
