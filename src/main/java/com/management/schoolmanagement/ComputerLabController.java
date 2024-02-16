//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import com.management.schoolmanagement.model.ComputerLab;
import com.management.schoolmanagement.model.ScienceLab;
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

public class ComputerLabController implements Initializable {
    ObservableList<ComputerLab> list = FXCollections.observableArrayList();
    ConnectionStatus c = new ConnectionStatus();
    ArrayList<ComputerLab> List = new ArrayList<>();
    @FXML
    private TableView<ComputerLab> Computertblview;
    @FXML
    private TableColumn<ScienceLab, Long> Id;
    @FXML
    private TableColumn<ScienceLab, String> name;
    @FXML
    private TableColumn<ScienceLab, String> status;
    @FXML
    private TextField searchbox;

    public ComputerLabController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.AllComputer();
    }

    @FXML
    void AddComputer() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Add Computer");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/add_ComputerLab.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    void EditComputer() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Edit Computer Details");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/edit_ComputerLab.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    void SearchComputer() {
        String Tid = this.searchbox.getText();
        long tid = Long.parseLong(Tid);
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Computertblview.getItems().clear();
        }

        try {
            this.List = this.c.GetSearchComputer(tid);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new ComputerLab(this.List.get(i).getID(), this.List.get(i).getName(), this.List.get(i).getStatus()));
            }

            this.Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.status.setCellValueFactory(new PropertyValueFactory<>("status"));
        }

    }

    @FXML
    void AllComputer() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Computertblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveCompputer();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new ComputerLab(this.List.get(i).getID(), this.List.get(i).getName(), this.List.get(i).getStatus()));
            }

            this.Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.status.setCellValueFactory(new PropertyValueFactory<>("status"));
            this.Computertblview.setItems(this.list);
        }

    }
}
