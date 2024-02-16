//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.modelcontroller;

import com.management.schoolmanagement.ConnectionStatus;
import com.management.schoolmanagement.model.Library;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editLibrary implements Initializable {
    ConnectionStatus con = new ConnectionStatus();
    @FXML
    TextField id;
    @FXML
    TextField Name;
    @FXML
    TextField subject;
    @FXML
    TextField searchid;
    @FXML
    Button closebtn;
    @FXML
    Button addbtn;
    @FXML
    Button searchbtn;
    @FXML
    Button delbtn;

    public editLibrary() {
    }

    int search() throws SQLException {
        ArrayList<Library> editlist = this.con.RetrieveLibrary();
        long id = Long.parseLong(this.searchid.getText());

        for(int i = 0; i < editlist.size(); ++i) {
            if (id == ((Library)editlist.get(i)).getID()) {
                return i;
            }
        }

        return -1;
    }

    @FXML
    void setEdit() {
        this.con.EditLibrary(Long.parseLong(this.id.getText()), this.Name.getText(), this.subject.getText(), Long.parseLong(this.searchid.getText()));
        Stage stage = (Stage)this.addbtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void close() {
        Stage stage = (Stage)this.closebtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void setSearchbtn() throws SQLException {
        ArrayList<Library> list = this.con.RetrieveLibrary();
        int i = this.search();
        if (i != -1) {
            this.id.setEditable(true);
            this.Name.setEditable(true);
            this.subject.setEditable(true);
            this.id.setText(String.valueOf(((Library)list.get(i)).getID()));
            this.Name.setText(((Library)list.get(i)).getName());
            this.subject.setText(((Library)list.get(i)).getSubject());
        }

    }

    @FXML
    void setDelete() {
        this.con.DelLibrary(Long.parseLong(this.searchid.getText()));
        Stage stage = (Stage)this.delbtn.getScene().getWindow();
        stage.close();
    }

    @Override
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
    }
}
