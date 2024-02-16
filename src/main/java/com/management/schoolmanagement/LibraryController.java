//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import com.management.schoolmanagement.model.Library;
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

public class LibraryController implements Initializable {
    ObservableList<Library> list = FXCollections.observableArrayList();
    ConnectionStatus c = new ConnectionStatus();
    ArrayList<Library> List = new ArrayList<>();
    @FXML
    private TableView<Library> Librarytblview;
    @FXML
    private TableColumn<Library, Long> Id;
    @FXML
    private TableColumn<Library, String> name;
    @FXML
    private TableColumn<Library, String> subject;
    @FXML
    private TextField searchbox;

    public LibraryController() {
    }

    @FXML
    void AddBooks() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Add Book");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/add_Library.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    void EditBooks() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Edit Book Details");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/edit_Library.fxml"));
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
        newWindow.show();
    }

    @FXML
    void SearchBooks() {
        String Tid = this.searchbox.getText();
        long tid = Long.parseLong(Tid);
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Librarytblview.getItems().clear();
        }

        try {
            this.List = this.c.GetSearchLibrary(tid);
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new Library(this.List.get(i).getID(), this.List.get(i).getName(), this.List.get(i).getSubject()));
            }

            this.Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        }

    }

    @FXML
    void AllBooks() {
        if (!this.List.isEmpty() && !this.list.isEmpty()) {
            this.List.clear();
            this.list.clear();
            this.Librarytblview.getItems().clear();
        }

        try {
            this.List = this.c.RetrieveLibrary();
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }

        if (!this.List.isEmpty()) {
            for(int i = 0; i <= this.List.size() - 1; ++i) {
                this.list.add(new Library(this.List.get(i).getID(), this.List.get(i).getName(), this.List.get(i).getSubject()));
            }

            this.Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.name.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
            this.Librarytblview.setItems(this.list);
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.AllBooks();
    }
}
