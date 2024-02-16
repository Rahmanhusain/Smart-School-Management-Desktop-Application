//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Teacher {
    SimpleLongProperty ID;
    SimpleLongProperty ClassTeacher;
    SimpleLongProperty Salary;
    SimpleStringProperty Name;
    SimpleStringProperty DOB;
    SimpleStringProperty Sex;
    SimpleStringProperty subject;
    SimpleStringProperty joindate;
    SimpleStringProperty Qulification;
    SimpleStringProperty leaving;

    public Teacher(long ID, String N, String Dob, String sex, long clteacher, String subject, String qualification, long salary, String joindate, String leavedate) {
        this.ID = new SimpleLongProperty(ID);
        this.Name = new SimpleStringProperty(N);
        this.DOB = new SimpleStringProperty(Dob);
        this.Sex = new SimpleStringProperty(sex);
        this.ClassTeacher = new SimpleLongProperty(clteacher);
        this.subject = new SimpleStringProperty(subject);
        this.Qulification = new SimpleStringProperty(qualification);
        this.joindate = new SimpleStringProperty(joindate);
        this.Salary = new SimpleLongProperty(salary);
        this.leaving = new SimpleStringProperty(leavedate);
    }

    public long getID() {
        return this.ID.get();
    }

    public void setID(long ID) {
        this.ID.set(ID);
    }

    public long getClassTeacher() {
        return this.ClassTeacher.get();
    }

    public void setClassTeacher(long classTeacher) {
        this.ClassTeacher.set(classTeacher);
    }

    public long getSalary() {
        return this.Salary.get();
    }

    public void setSalary(long salary) {
        this.Salary.set(salary);
    }

    public String getName() {
        return this.Name.get();
    }

    public void setName(String name) {
        this.Name.set(name);
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

    public String getSubject() {
        return this.subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public String getJoindate() {
        return this.joindate.get();
    }

    public void setJoindate(String joindate) {
        this.joindate.set(joindate);
    }

    public String getQulification() {
        return this.Qulification.get();
    }

    public void setQulification(String qulification) {
        this.Qulification.set(qulification);
    }

    public String getLeaving() {
        return this.leaving.get();
    }

    public void setLeaving(String leaving) {
        this.leaving.set(leaving);
    }
}
