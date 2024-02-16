//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

public class School {
    long Id;
    String Name;
    String address;
    String opendate;
    String Prinvipalname;

    public School(long Id, String Name, String address, String opendate, String prinvipalname) {
        this.Id = Id;
        this.Name = Name;
        this.address = address;
        this.opendate = opendate;
        this.Prinvipalname = prinvipalname;
    }

    public long getId() {
        return this.Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpendate() {
        return this.opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    public String getPrinvipalname() {
        return this.Prinvipalname;
    }

    public void setPrinvipalname(String prinvipalname) {
        this.Prinvipalname = prinvipalname;
    }
}
