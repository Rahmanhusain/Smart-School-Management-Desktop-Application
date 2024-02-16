//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import com.management.schoolmanagement.model.Fee;
import com.management.schoolmanagement.model.School;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    ObservableList<Fee> list = FXCollections.observableArrayList();
    ConnectionStatus c = new ConnectionStatus();
    ArrayList<Fee> List = new ArrayList<>();
    ArrayList<School> SList = new ArrayList<>();
    @FXML
    private TableColumn<Fee, String> Class;
    @FXML
    private Label address;
    @FXML
    private Label date;
    @FXML
    private TableColumn<Fee, Long> fee;
    @FXML
    private Label name;
    @FXML
    private Label pname;
    @FXML
    private Label scid;
    @FXML
    private TableView<Fee> stucturetblview;
    @FXML
    private Label tbooks;
    @FXML
    private Label tcomputers;
    @FXML
    private Label tequipment;
    @FXML
    private Label tstudent;
    @FXML
    private Label tteacher;

    public DashBoardController() {
    }

    @FXML
    void editschooldetails() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Edit School Details");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/editSchool.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    void EditFeestructure() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Edit Fee Details");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/editFee.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    void AllFee() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.stucturetblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveFee();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new Fee(this.List.get(i).getClasses(), this.List.get(i).getFee()));
            }

            this.Class.setCellValueFactory(new PropertyValueFactory<>("Classes"));
            this.fee.setCellValueFactory(new PropertyValueFactory<>("fee"));
            this.stucturetblview.setItems(this.list);
        }

    }

    void AllSchool() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.stucturetblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveFee();
        } catch (SQLException var3) {
            throw new RuntimeException(var3);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new Fee(this.List.get(i).getClasses(), this.List.get(i).getFee()));
            }

            this.Class.setCellValueFactory(new PropertyValueFactory<>("Classes"));
            this.fee.setCellValueFactory(new PropertyValueFactory<>("fee"));
            this.stucturetblview.setItems(this.list);
        }

        if (!this.SList.isEmpty()) {
            this.SList.clear();
        }

        try {
            this.SList = this.c.RetrieveSchool();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.SList.isEmpty()) {
            this.scid.setText(String.valueOf(this.SList.get(0).getId()));
            this.name.setText(this.SList.get(0).getName());
            this.address.setText(this.SList.get(0).getAddress());
            this.date.setText(this.SList.get(0).getOpendate());
            this.pname.setText(this.SList.get(0).getPrinvipalname());
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.AllFee();
        this.AllSchool();

        try {
            this.tstudent.setText("Total Students : " + this.c.studentcount());
            this.tbooks.setText("Total Books in Library : " + this.c.libcount());
            this.tteacher.setText("Total Teachers : " + this.c.teachercount());
            this.tequipment.setText("Total Equipment in Science Lab :  " + this.c.scicount());
            this.tcomputers.setText("Total computers in Lab : " + this.c.compcount());
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    @FXML
    void reload() {
        this.AllFee();
        this.AllSchool();
    }
}
