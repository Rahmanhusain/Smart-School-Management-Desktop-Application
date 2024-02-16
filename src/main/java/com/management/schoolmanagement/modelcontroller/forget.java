//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.modelcontroller;

import com.management.schoolmanagement.ConnectionStatus;
import com.management.schoolmanagement.SendEmail;
import com.management.schoolmanagement.model.usermodel;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class forget {
    @FXML
    Button btn;
    ConnectionStatus c = new ConnectionStatus();
    ArrayList<usermodel> user = new ArrayList();
    @FXML
    private TextField userid;
    @FXML
    private Label messege;

    public forget() {
    }

    @FXML
    void GetPassword() throws SQLException {
        if (this.search() != -1) {
            if (this.netIsAvailable()) {
                this.messege.setTextFill(Paint.valueOf("Green"));
                SendEmail.sendmail(((usermodel)this.user.get(0)).getEmail(), ((usermodel)this.user.get(0)).getPass(), this.userid.getText());
                this.messege.setText("The Password has been sent on your Registered email !");
                this.btn.setDisable(true);
            } else {
                this.messege.setTextFill(Paint.valueOf("Red"));
                this.messege.setText("Could not send Check Internet Connection !");
            }
        } else {
            this.messege.setTextFill(Paint.valueOf("Red"));
            this.messege.setText("⚠ wrong userid");
        }

    }

    int search() throws SQLException {
        this.user = this.c.Retrieveuser(this.userid.getText());
        if (!this.user.isEmpty()) {
            for(int i = 0; i < this.user.size(); ++i) {
                if (this.userid.getText().equals(((usermodel)this.user.get(i)).getUserid())) {
                    return i;
                }
            }
        }

        return -1;
    }

    private boolean netIsAvailable() {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException var3) {
            throw new RuntimeException(var3);
        } catch (IOException var4) {
            return false;
        }
    }
}
