//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

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

public class ScienceLabController implements Initializable {
    ObservableList<ScienceLab> list = FXCollections.observableArrayList();
    ConnectionStatus c = new ConnectionStatus();
    ArrayList<ScienceLab> List = new ArrayList<>();
    @FXML
    private TableView<ScienceLab> Sciencetblview;
    @FXML
    private TableColumn<ScienceLab, Long> Id;
    @FXML
    private TableColumn<ScienceLab, String> name;
    @FXML
    private TextField searchbox;

    public ScienceLabController() {
    }

    @FXML
    void AddEquipment() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Add Sci. Lab Equipment");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/add_ScienceLab.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    void EditEquipment() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Edit Sci. Lab Equipment");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/edit_ScienceLab.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    void SearchEquipment() {
        String Tid = this.searchbox.getText();
        long tid = Long.parseLong(Tid);
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Sciencetblview.getItems().clear();
        }

        try {
            this.List = this.c.GetSearchSciLabEquipment(tid);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new ScienceLab(this.List.get(i).getID(), this.List.get(i).getName()));
            }

            this.Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
        }

    }

    @FXML
    void AllEquipment() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Sciencetblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveSciLabEquipment();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new ScienceLab(this.List.get(i).getID(), this.List.get(i).getName()));
            }

            this.Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.Sciencetblview.setItems(this.list);
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.AllEquipment();
    }
}
