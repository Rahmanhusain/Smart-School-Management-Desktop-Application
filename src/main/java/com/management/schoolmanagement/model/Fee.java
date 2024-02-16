//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Fee {
    SimpleLongProperty fee;
    SimpleStringProperty Classes;

    public Fee(String Class, Long fee) {
        this.Classes = new SimpleStringProperty(Class);
        this.fee = new SimpleLongProperty(fee);
    }

    public long getFee() {
        return this.fee.get();
    }

    public void setFee(long fee) {
        this.fee.set(fee);
    }

    public String getClasses() {
        return this.Classes.get();
    }

    public  void setClasses(String classes) {
        this.Classes.set(classes);
    }
}
