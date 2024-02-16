//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Library {
    SimpleLongProperty ID;
    SimpleStringProperty name;
    SimpleStringProperty subject;

    public Library(long ID, String name, String subject) {
        this.ID = new SimpleLongProperty(ID);
        this.name = new SimpleStringProperty(name);
        this.subject = new SimpleStringProperty(subject);
    }

    public String getSubject() {
        return this.subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
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
