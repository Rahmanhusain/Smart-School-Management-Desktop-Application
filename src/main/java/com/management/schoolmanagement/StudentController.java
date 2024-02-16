//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import com.management.schoolmanagement.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
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

public class StudentController implements Initializable {
    ObservableList<Student> list = FXCollections.observableArrayList();
    ConnectionStatus c = new ConnectionStatus();
    ArrayList<Student> List = new ArrayList<>();
    String[] stufilter = new String[]{"All Student", "Current Student", "Ex Student"};
    @FXML
    ChoiceBox<String> chbox;
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

    public StudentController() {
    }

    @FXML
    protected void addstudent() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Add Students");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/add_student.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    protected void Editstudent() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Edit Students");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/editStudent.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    protected void currentStudent() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Studenttblview.getItems().clear();
        }

        try {
            this.List = this.c.GetCurrentStudent();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.List.isEmpty()) {
            System.out.println(this.List.get(1).getSex());

            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new Student(this.List.get(i).getRoll_no(), this.List.get(i).getName(), this.List.get(i).getDOB(), this.List.get(i).getSex(), this.List.get(i).getClasses(), this.List.get(i).getSec(), this.List.get(i).getFather(), this.List.get(i).getMother(), this.List.get(i).getEnroll(), this.List.get(i).getAdmission(), this.List.get(i).getFee(), this.List.get(i).getStatus(), this.List.get(i).getLeaving()));
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

    protected void Exstudent() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Studenttblview.getItems().clear();
        }

        try {
            this.List = this.c.GetExStudent();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new Student(this.List.get(i).getRoll_no(), this.List.get(i).getName(), this.List.get(i).getDOB(), this.List.get(i).getSex(), this.List.get(i).getClasses(), this.List.get(i).getSec(), this.List.get(i).getFather(), this.List.get(i).getMother(), this.List.get(i).getEnroll(), this.List.get(i).getAdmission(), this.List.get(i).getFee(), this.List.get(i).getStatus(), this.List.get(i).getLeaving()));
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

    @FXML
    protected void Allstudent() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Studenttblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveStudent();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new Student(this.List.get(i).getRoll_no(), this.List.get(i).getName(), this.List.get(i).getDOB(), this.List.get(i).getSex(), this.List.get(i).getClasses(), this.List.get(i).getSec(), this.List.get(i).getFather(), this.List.get(i).getMother(), this.List.get(i).getEnroll(), this.List.get(i).getAdmission(), this.List.get(i).getFee(), this.List.get(i).getStatus(), this.List.get(i).getLeaving()));
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

    @FXML
    protected void SearchStudent() {
        String Sid = this.searchbox.getText().toUpperCase();
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

    @FXML
    void setChbox() {
        if (this.chbox.getValue().equals("Current Student")) {
            this.currentStudent();
        } else if (this.chbox.getValue().equals("Ex Student")) {
            this.Exstudent();
        } else if (this.chbox.getValue().equals("All Student")) {
            this.Allstudent();
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.Allstudent();
        this.chbox.getItems().addAll(this.stufilter);
        this.chbox.setValue("All Student");
    }
}
