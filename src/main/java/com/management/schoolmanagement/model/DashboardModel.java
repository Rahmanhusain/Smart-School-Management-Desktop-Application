//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement.model;

public class DashboardModel {
    int student;
    int teachers;
    int equipment;
    int computer;
    int books;

    public DashboardModel(int student, int teachers, int equipment, int computer, int books) {
        this.student = student;
        this.teachers = teachers;
        this.equipment = equipment;
        this.computer = computer;
        this.books = books;
    }

    public int getStudent() {
        return this.student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getTeachers() {
        return this.teachers;
    }

    public void setTeachers(int teachers) {
        this.teachers = teachers;
    }

    public int getEquipment() {
        return this.equipment;
    }

    public void setEquipment(int equipment) {
        this.equipment = equipment;
    }

    public int getComputer() {
        return this.computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }

    public int getBooks() {
        return this.books;
    }

    public void setBooks(int books) {
        this.books = books;
    }
}
