//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    SimpleLongProperty Roll_no;
    SimpleLongProperty Classes;
    SimpleLongProperty Enroll;
    SimpleLongProperty Fee;
    SimpleStringProperty Name;
    SimpleStringProperty Father;
    SimpleStringProperty Mother;
    SimpleStringProperty DOB;
    SimpleStringProperty Sex;
    SimpleStringProperty sec;
    SimpleStringProperty Admission;
    SimpleStringProperty Status;
    SimpleStringProperty leaving;

    public Student(long r, String N, String Dob, String s, long cl, String se, String fa, String mo, long en, String ad, long f, String st, String l) {
        this.Roll_no = new SimpleLongProperty(r);
        this.Name = new SimpleStringProperty(N);
        this.DOB = new SimpleStringProperty(Dob);
        this.Sex = new SimpleStringProperty(s);
        this.Classes = new SimpleLongProperty(cl);
        this.sec = new SimpleStringProperty(se);
        this.Father = new SimpleStringProperty(fa);
        this.Mother = new SimpleStringProperty(mo);
        this.Enroll = new SimpleLongProperty(en);
        this.Admission = new SimpleStringProperty(ad);
        this.Fee = new SimpleLongProperty(f);
        this.Status = new SimpleStringProperty(st);
        this.leaving = new SimpleStringProperty(l);
    }

    public long getRoll_no() {
        return this.Roll_no.get();
    }

    public void setRoll_no(long roll_no) {
        this.Roll_no.set(roll_no);
    }

    public long getClasses() {
        return this.Classes.get();
    }

    public void setClasses(long classes) {
        this.Classes.set(classes);
    }

    public long getEnroll() {
        return this.Enroll.get();
    }

    public void setEnroll(long enroll) {
        this.Enroll.set(enroll);
    }

    public long getFee() {
        return this.Fee.get();
    }

    public void setFee(long fee) {
        this.Fee.set(fee);
    }

    public String getName() {
        return this.Name.get();
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getFather() {
        return this.Father.get();
    }

    public void setFather(String father) {
        this.Father.set(father);
    }

    public String getMother() {
        return this.Mother.get();
    }

    public void setMother(String mother) {
        this.Mother.set(mother);
    }

    public String getDOB() {
        return this.DOB.get();
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
    }

    public String getSex() {
        return this.Sex.get();
    }

    public void setSex(String sex) {
        this.Sex.set(sex);
    }

    public String getSec() {
        return this.sec.get();
    }

    public void setSec(String sec) {
        this.sec.set(sec);
    }

    public String getAdmission() {
        return this.Admission.get();
    }

    public void setAdmission(String admission) {
        this.Admission.set(admission);
    }

    public String getStatus() {
        return this.Status.get();
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }

    public String getLeaving() {
        return this.leaving.get();
    }

    public void setLeaving(String leaving) {
        this.leaving.set(leaving);
    }
}
