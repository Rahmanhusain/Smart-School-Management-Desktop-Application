//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ComputerLab {
    SimpleLongProperty ID;
    SimpleStringProperty name;
    SimpleStringProperty status;

    public ComputerLab(long ID, String name, String status) {
        this.ID = new SimpleLongProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.status = new SimpleStringProperty(status);
    }

    public String getStatus() {
        return this.status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public long getID() {
        return this.ID.get();
    }

    public void setID(long ID) {
        this.ID.set(ID);
    }

    public String getName() {
        return this.name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
