//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ScienceLab {
    SimpleLongProperty ID;
    SimpleStringProperty name;

    public ScienceLab(long ID, String name) {
        this.ID = new SimpleLongProperty(ID);
        this.name = new SimpleStringProperty(name);
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
