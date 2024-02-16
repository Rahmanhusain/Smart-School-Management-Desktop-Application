//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import com.management.schoolmanagement.model.usermodel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Login implements Initializable {
    ConnectionStatus c = new ConnectionStatus();
    String[] userch = new String[]{"Admin", "Student"};
    @FXML
    ChoiceBox<String> chbox;
    @FXML
    private Button login;
    @FXML
    private PasswordField password;
    @FXML
    Label status;
    @FXML
    private TextField userid;

    public Login() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.chbox.getItems().addAll(this.userch);
        this.chbox.setValue("Admin");
    }

    int search() throws SQLException {
        ArrayList<usermodel> user = this.c.Retrieveuser(this.chbox.getValue());
        if (!user.isEmpty()) {
            for(int i = 0; i < user.size(); ++i) {
                if (this.userid.getText().equals(user.get(i).getUserid()) && this.password.getText().equals(user.get(i).getPass()) && this.chbox.getValue().equals(user.get(i).getUser())) {
                    return i;
                }
            }
        }

        return -1;
    }

    @FXML
    void login() throws IOException, SQLException {
        Stage newWindow;
        FXMLLoader loader;
        Stage stage;
        if (this.chbox.getValue().equals("Admin")) {
            if (this.search() != -1) {
                newWindow = new Stage();
                newWindow.setTitle("Welcome to Smart School Management");
                newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
                loader = new FXMLLoader(this.getClass().getResource("hello-view.fxml"));
                newWindow.setScene(new Scene(loader.load()));
                newWindow.show();
                newWindow.setMaximized(false);
                newWindow.setResizable(false);
                stage = (Stage)this.login.getScene().getWindow();
                stage.close();
            } else {
                this.status.setText("⚠ wrong userid or password!");
            }
        } else if (this.chbox.getValue().equals("Student")) {
            if (this.search() != -1) {
                newWindow = new Stage();
                newWindow.setTitle("Welcome to Smart School Management");
                loader = new FXMLLoader(this.getClass().getResource("StudentLogin.fxml"));
                newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
                newWindow.setScene(new Scene(loader.load()));
                newWindow.show();
                newWindow.setMaximized(false);
                newWindow.setResizable(false);
                stage = (Stage)this.login.getScene().getWindow();
                stage.close();
            } else {
                this.status.setText("⚠ wrong userid or password!");
            }
        }

    }

    @FXML
    void forget() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Forget Password");
        newWindow.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("styles/slogo.png")).openStream()));
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("modelfxml/forget.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        newWindow.setMaximized(false);
        newWindow.setResizable(false);
    }
}
