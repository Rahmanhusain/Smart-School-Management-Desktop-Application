//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.management.schoolmanagement;

import DButil.Dbconnection;
import com.management.schoolmanagement.model.ComputerLab;
import com.management.schoolmanagement.model.Fee;
import com.management.schoolmanagement.model.Library;
import com.management.schoolmanagement.model.School;
import com.management.schoolmanagement.model.ScienceLab;
import com.management.schoolmanagement.model.Student;
import com.management.schoolmanagement.model.Teacher;
import com.management.schoolmanagement.model.usermodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionStatus {
    Connection connection = Dbconnection.getconnection();

    public ConnectionStatus() {
        if (this.connection == null) {
            System.exit(1);
        }

    }

    public boolean isconnected() {
        return this.connection != null;
    }

    public void InsertStudent(long roll, String name, String dob, String sex, long Class, String section, String father, String mother, long enrollnum, String Admissiondate, long feedue, String Status, String leavingdate) {
        String sql = "INSERT INTO students(Roll_no,Name,DOB,Sex,Class,Section,Father_Name,Mother_Name,Enrollment_number,Admission_Date,Fee_due,Status,Leaving_date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, roll);
                pstmt.setString(2, name);
                pstmt.setString(3, dob);
                pstmt.setString(4, sex);
                pstmt.setLong(5, Class);
                pstmt.setString(6, section);
                pstmt.setString(7, father);
                pstmt.setString(8, mother);
                pstmt.setLong(9, enrollnum);
                pstmt.setString(10, Admissiondate);
                pstmt.setLong(11, feedue);
                pstmt.setString(12, Status);
                pstmt.setString(13, leavingdate);
                pstmt.executeUpdate();
                System.out.println("data inserted successfully");
            } catch (Throwable var23) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var22) {
                        var23.addSuppressed(var22);
                    }
                }

                throw var23;
            }

            pstmt.close();
        } catch (SQLException var24) {
            System.out.println("failed to insert data due to: " + var24.getMessage());
        }

    }

    public void EditStudent(long roll, String name, String dob, String sex, long Class, String section, String father, String mother, long enrollnum, String Admissiondate, long feedue, String Status, String leavingdate, long sid) {
        String sql = "UPDATE students SET Roll_no = ?,Name = ?,DOB = ?,Sex = ?,Class = ? ,Section = ?,Father_Name = ?,Mother_Name = ?,Enrollment_number = ?,Admission_Date = ?,Fee_due = ?,Status = ?,Leaving_date = ?WHERE Roll_no=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, roll);
                pstmt.setString(2, name);
                pstmt.setString(3, dob);
                pstmt.setString(4, sex);
                pstmt.setLong(5, Class);
                pstmt.setString(6, section);
                pstmt.setString(7, father);
                pstmt.setString(8, mother);
                pstmt.setLong(9, enrollnum);
                pstmt.setString(10, Admissiondate);
                pstmt.setLong(11, feedue);
                pstmt.setString(12, Status);
                pstmt.setString(13, leavingdate);
                pstmt.setLong(14, sid);
                pstmt.executeUpdate();
                System.out.println("data edited successfully");
            } catch (Throwable var25) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var24) {
                        var25.addSuppressed(var24);
                    }
                }

                throw var25;
            }

            pstmt.close();
        } catch (SQLException var26) {
            System.out.println("failed to edit data due to: " + var26.getMessage());
        }

    }

    public ArrayList<Student> RetrieveStudent() throws SQLException {
        ArrayList<Student> sdata = new ArrayList<>();
        Statement stmt;
        stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students ORDER BY Class ;");

        while(rs.next()) {
            sdata.add(new Student(rs.getLong("Roll_no"), rs.getString("Name"), rs.getString("DOB"), rs.getString("Sex"), rs.getLong("Class"), rs.getString("Section"), rs.getString("Father_Name"), rs.getString("Mother_Name"), rs.getLong("Enrollment_number"), rs.getString("Admission_Date"), rs.getInt("Fee_due"), rs.getString("Status"), rs.getString("Leaving_date")));
        }

        return sdata;
    }

    public ArrayList<Student> GetCurrentStudent() throws SQLException {
        ArrayList<Student> cdata = new ArrayList<>();
        Statement stmt2;
        stmt2 = this.connection.createStatement();
        ResultSet rs = stmt2.executeQuery("SELECT * FROM students WHERE Status='Studying' ;");

        while(rs.next()) {
            cdata.add(new Student(rs.getLong("Roll_no"), rs.getString("Name"), rs.getString("DOB"), rs.getString("Sex"), rs.getLong("Class"), rs.getString("Section"), rs.getString("Father_Name"), rs.getString("Mother_Name"), rs.getLong("Enrollment_number"), rs.getString("Admission_Date"), rs.getInt("Fee_due"), rs.getString("Status"), rs.getString("Leaving_date")));
        }

        return cdata;
    }

    public ArrayList<Student> GetExStudent() throws SQLException {
        ArrayList<Student> edata = new ArrayList<>();
        Statement stmt3;
        stmt3 = this.connection.createStatement();
        ResultSet rs = stmt3.executeQuery("SELECT * FROM students WHERE Status='Ex Student' ;");

        while(rs.next()) {
            edata.add(new Student(rs.getLong("Roll_no"), rs.getString("Name"), rs.getString("DOB"), rs.getString("Sex"), rs.getLong("Class"), rs.getString("Section"), rs.getString("Father_Name"), rs.getString("Mother_Name"), rs.getLong("Enrollment_number"), rs.getString("Admission_Date"), rs.getInt("Fee_due"), rs.getString("Status"), rs.getString("Leaving_date")));
        }

        return edata;
    }

    public void Delstudent(long sid) {
        String sql = "DELETE FROM students WHERE Roll_no=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, sid);
                pstmt.executeUpdate();
                System.out.println("data deleted successfully");
            } catch (Throwable var8) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            pstmt.close();
        } catch (SQLException var9) {
            System.out.println("failed to delete data due to: " + var9.getMessage());
        }

    }

    public void InsertTeachers(long ID, String name, String dob, String sex, long Classteacher, String subject, String Qualification, long salary, String joindate, String leavingdate) {
        String sql = "INSERT INTO teachers(id,Name,Sex,DOB,subject,Class_teacher,Qualification,Salary,Joining_date,Leaving_date) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.setString(3, sex);
                pstmt.setString(4, dob);
                pstmt.setString(5, subject);
                pstmt.setLong(6, Classteacher);
                pstmt.setString(7, Qualification);
                pstmt.setLong(8, salary);
                pstmt.setString(9, joindate);
                pstmt.setString(10, leavingdate);
                pstmt.executeUpdate();
                System.out.println("data inserted successfully");
            } catch (Throwable var19) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var18) {
                        var19.addSuppressed(var18);
                    }
                }

                throw var19;
            }

            pstmt.close();
        } catch (SQLException var20) {
            System.out.println("failed to insert data due to: " + var20.getMessage());
        }

    }

    public void EditTeachers(long ID, String name, String dob, String sex, long Classteacher, String subject, String Qualification, long salary, String joindate, String leavingdate, long eid) {
        String sql = "UPDATE teachers SET id = ?,Name = ?,Sex = ?,DOB = ?,subject = ? ,Class_teacher = ?,Qualification = ?,Salary = ?,Joining_date = ?,Leaving_date = ? WHERE id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.setString(3, sex);
                pstmt.setString(4, dob);
                pstmt.setString(5, subject);
                pstmt.setLong(6, Classteacher);
                pstmt.setString(7, Qualification);
                pstmt.setLong(8, salary);
                pstmt.setString(9, joindate);
                pstmt.setString(10, leavingdate);
                pstmt.setLong(11, eid);
                pstmt.executeUpdate();
                System.out.println("data teachers edited successfully");
            } catch (Throwable var21) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var20) {
                        var21.addSuppressed(var20);
                    }
                }

                throw var21;
            }

            pstmt.close();
        } catch (SQLException var22) {
            System.out.println("failed to edit teacher data due to: " + var22.getMessage());
        }

    }

    public void DelTeacher(long sid) {
        String sql = "DELETE FROM teachers WHERE id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, sid);
                pstmt.executeUpdate();
                System.out.println("data teacher deleted successfully");
            } catch (Throwable var8) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            pstmt.close();
        } catch (SQLException var9) {
            System.out.println("failed to delete teacher data due to: " + var9.getMessage());
        }

    }

    public ArrayList<Teacher> RetrieveTeachers() throws SQLException {
        ArrayList<Teacher> sdata = new ArrayList<>();
        Statement stmt;
        stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM teachers ORDER BY Class_teacher ;");

        while(rs.next()) {
            sdata.add(new Teacher(rs.getLong("id"), rs.getString("Name"), rs.getString("DOB"), rs.getString("Sex"), rs.getLong("Class_teacher"), rs.getString("subject"), rs.getString("Qualification"), rs.getLong("Salary"), rs.getString("Joining_date"), rs.getString("Leaving_date")));
        }

        return sdata;
    }

    public ArrayList<Teacher> GetSearchTeacher(String Name) throws SQLException {
        ArrayList<Teacher> edata = new ArrayList<>();
        String sql = "SELECT * FROM teachers WHERE Name=?;";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setString(1, Name);
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()) {
                    edata.add(new Teacher(rs.getLong("id"), rs.getString("Name"), rs.getString("DOB"), rs.getString("Sex"), rs.getLong("Class_teacher"), rs.getString("subject"), rs.getString("Qualification"), rs.getLong("Salary"), rs.getString("Joining_date"), rs.getString("Leaving_date")));
                }
            } catch (Throwable var8) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            pstmt.close();
        } catch (SQLException var9) {
            System.out.println(var9.getMessage());
        }

        return edata;
    }

    public void InsertSciLabEquipment(long ID, String name) {
        String sql = "INSERT INTO Science_lab(item_id,Name) VALUES(?,?)";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.executeUpdate();
                System.out.println("data inserted science successfully");
            } catch (Throwable var9) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            pstmt.close();
        } catch (SQLException var10) {
            System.out.println("failed to insert Science data due to: " + var10.getMessage());
        }

    }

    public void EditSciLabEquipment(long ID, String name, long eid) {
        String sql = "UPDATE Science_lab SET item_id = ?,Name = ? WHERE item_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.setLong(3, eid);
                pstmt.executeUpdate();
                System.out.println("data science edited successfully");
            } catch (Throwable var11) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var10) {
                        var11.addSuppressed(var10);
                    }
                }

                throw var11;
            }

            pstmt.close();
        } catch (SQLException var12) {
            System.out.println("failed to edit science data due to: " + var12.getMessage());
        }

    }

    public void DelSciLabEquipment(long sid) {
        String sql = "DELETE FROM Science_lab WHERE item_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, sid);
                pstmt.executeUpdate();
                System.out.println("data teacher science successfully");
            } catch (Throwable var8) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            pstmt.close();
        } catch (SQLException var9) {
            System.out.println("failed to delete science data due to: " + var9.getMessage());
        }

    }

    public ArrayList<ScienceLab> RetrieveSciLabEquipment() throws SQLException {
        ArrayList<ScienceLab> sdata = new ArrayList<>();
        Statement stmt;
        stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Science_lab ORDER BY item_id ;");

        while(rs.next()) {
            sdata.add(new ScienceLab(rs.getLong("item_id"), rs.getString("Name")));
        }

        return sdata;
    }

    public ArrayList<ScienceLab> GetSearchSciLabEquipment(long id) throws SQLException {
        ArrayList<ScienceLab> edata = new ArrayList<>();
        Statement stmt3;
        stmt3 = this.connection.createStatement();
        ResultSet rs = stmt3.executeQuery("SELECT * FROM Science_lab WHERE item_id=" + id + ";");

        while(rs.next()) {
            edata.add(new ScienceLab(rs.getLong("item_id"), rs.getString("Name")));
        }

        return edata;
    }

    public void InsertComputer(long ID, String name, String status) {
        String sql = "INSERT INTO computer_lab(comp_id,Brand,working_status) VALUES(?,?,?)";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.setString(3, status);
                pstmt.executeUpdate();
                System.out.println("data inserted computer successfully");
            } catch (Throwable var10) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                    }
                }

                throw var10;
            }

            pstmt.close();
        } catch (SQLException var11) {
            System.out.println("failed to insert computer data due to: " + var11.getMessage());
        }

    }

    public void EditComputer(long ID, String name, String status, long eid) {
        String sql = "UPDATE computer_lab SET comp_id = ?,Brand = ?,working_status = ? WHERE comp_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.setString(3, status);
                pstmt.setLong(4, eid);
                pstmt.executeUpdate();
                System.out.println("data computer edited successfully");
            } catch (Throwable var12) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var11) {
                        var12.addSuppressed(var11);
                    }
                }

                throw var12;
            }

            pstmt.close();
        } catch (SQLException var13) {
            System.out.println("failed to edit computer data due to: " + var13.getMessage());
        }

    }

    public void DelComputer(long sid) {
        String sql = "DELETE FROM computer_lab WHERE comp_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, sid);
                pstmt.executeUpdate();
                System.out.println("data deleted computer successfully");
            } catch (Throwable var8) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            pstmt.close();
        } catch (SQLException var9) {
            System.out.println("failed to delete computer data due to: " + var9.getMessage());
        }

    }

    public ArrayList<ComputerLab> RetrieveCompputer() throws SQLException {
        ArrayList<ComputerLab> sdata = new ArrayList<>();
        Statement stmt;
        stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM computer_lab ORDER BY comp_id ;");

        while(rs.next()) {
            sdata.add(new ComputerLab(rs.getLong("comp_id"), rs.getString("Brand"), rs.getString("working_status")));
        }

        return sdata;
    }

    public ArrayList<ComputerLab> GetSearchComputer(long id) throws SQLException {
        ArrayList<ComputerLab> edata = new ArrayList<>();
        Statement stmt3;
        stmt3 = this.connection.createStatement();
        ResultSet rs = stmt3.executeQuery("SELECT * FROM computer_lab WHERE comp_id=" + id + ";");

        while(rs.next()) {
            edata.add(new ComputerLab(rs.getLong("comp_id"), rs.getString("Brand"), rs.getString("working_status")));
        }

        return edata;
    }

    public void InsertLibrary(long ID, String name, String subject) {
        String sql = "INSERT INTO Library(Book_id ,Book_name,subject) VALUES(?,?,?)";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.setString(3, subject);
                pstmt.executeUpdate();
                System.out.println("data inserted Libraray successfully");
            } catch (Throwable var10) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                    }
                }

                throw var10;
            }

            pstmt.close();
        } catch (SQLException var11) {
            System.out.println("failed to insert Libraray data due to: " + var11.getMessage());
        }

    }

    public void EditLibrary(long ID, String name, String subject, long eid) {
        String sql = "UPDATE Library SET Book_id = ?,Book_name = ?,subject = ? WHERE Book_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.setString(3, subject);
                pstmt.setLong(4, eid);
                pstmt.executeUpdate();
                System.out.println("data Libraray edited successfully");
            } catch (Throwable var12) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var11) {
                        var12.addSuppressed(var11);
                    }
                }

                throw var12;
            }

            pstmt.close();
        } catch (SQLException var13) {
            System.out.println("failed to edit Libraray data due to: " + var13.getMessage());
        }

    }

    public void DelLibrary(long sid) {
        String sql = "DELETE FROM Library WHERE Book_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, sid);
                pstmt.executeUpdate();
                System.out.println("data deleted Libraray successfully");
            } catch (Throwable var8) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            pstmt.close();
        } catch (SQLException var9) {
            System.out.println("failed to delete Libraray data due to: " + var9.getMessage());
        }

    }

    public ArrayList<Library> RetrieveLibrary() throws SQLException {
        ArrayList<Library> sdata = new ArrayList<>();
        Statement stmt;
        stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Library ORDER BY Book_id ;");

        while(rs.next()) {
            sdata.add(new Library(rs.getLong("Book_id"), rs.getString("Book_name"), rs.getString("subject")));
        }

        return sdata;
    }

    public ArrayList<Library> GetSearchLibrary(long id) throws SQLException {
        ArrayList<Library> edata = new ArrayList<>();
        Statement stmt3;
        stmt3 = this.connection.createStatement();
        ResultSet rs = stmt3.executeQuery("SELECT * FROM Library WHERE Book_id=" + id + ";");

        while(rs.next()) {
            edata.add(new Library(rs.getLong("Book_id"), rs.getString("Book_name"), rs.getString("subject")));
        }

        return edata;
    }

    public void EditSchool(long ID, String name, String address, String Opendate, String Pname, long eid) {
        String sql = "UPDATE School_details SET school_id = ?,School_name = ?,address = ?,opening_date = ?,Principal_name = ? WHERE school_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setLong(1, ID);
                pstmt.setString(2, name);
                pstmt.setString(3, address);
                pstmt.setString(4, Opendate);
                pstmt.setString(5, Pname);
                pstmt.setLong(6, eid);
                pstmt.executeUpdate();
                System.out.println("data school edited successfully");
            } catch (Throwable var14) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var13) {
                        var14.addSuppressed(var13);
                    }
                }

                throw var14;
            }

            pstmt.close();
        } catch (SQLException var15) {
            System.out.println("failed to edit school data due to: " + var15.getMessage());
        }

    }

    public void Editfee(String Class, long fee, String eid) {
        String sql = "UPDATE Fee_structure SET class = ?,Fee = ? WHERE class=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setString(1, Class);
                pstmt.setLong(2, fee);
                pstmt.setString(3, eid);
                pstmt.executeUpdate();
                System.out.println("data school Fee_structure successfully");
            } catch (Throwable var10) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                    }
                }

                throw var10;
            }

            pstmt.close();
        } catch (SQLException var11) {
            System.out.println("failed to edit Fee_structure data due to: " + var11.getMessage());
        }

    }

    public ArrayList<School> RetrieveSchool() throws SQLException {
        ArrayList<School> sdata = new ArrayList<>();
        Statement stmt;
        stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM School_details;");

        while(rs.next()) {
            sdata.add(new School(rs.getLong("school_id"), rs.getString("School_name"), rs.getString("address"), rs.getString("opening_date"), rs.getString("Principal_name")));
        }

        return sdata;
    }

    public ArrayList<Fee> RetrieveFee() throws SQLException {
        ArrayList<Fee> sdata = new ArrayList<>();
        Statement stmt;
        stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Fee_structure;");

        while(rs.next()) {
            sdata.add(new Fee(rs.getString("class"), rs.getLong("Fee")));
        }

        return sdata;
    }

    public int studentcount() throws SQLException {
        Statement stmt;
        stmt = this.connection.createStatement();
        int count = 0;

        for(ResultSet rs1 = stmt.executeQuery("SELECT COUNT(Roll_no ) AS cstudent FROM students;"); rs1.next(); count = rs1.getInt("cstudent")) {
        }

        return count;
    }

    public int teachercount() throws SQLException {
        Statement stmt;
        stmt = this.connection.createStatement();
        int count = 0;

        for(ResultSet rs2 = stmt.executeQuery("SELECT COUNT(id ) AS cteachers FROM  teachers;"); rs2.next(); count = rs2.getInt("cteachers")) {
        }

        return count;
    }

    public int libcount() throws SQLException {
        Statement stmt;
        stmt = this.connection.createStatement();
        int count = 0;

        for(ResultSet rs3 = stmt.executeQuery("SELECT COUNT(  Book_id ) AS clib FROM Library;"); rs3.next(); count = rs3.getInt("clib")) {
        }

        return count;
    }

    public int scicount() throws SQLException {
        Statement stmt;
        stmt = this.connection.createStatement();
        int count = 0;

        for(ResultSet rs4 = stmt.executeQuery("SELECT COUNT(item_id ) AS csci FROM  Science_lab;"); rs4.next(); count = rs4.getInt("csci")) {
        }

        return count;
    }

    public int usercount() throws SQLException {
        Statement stmt;
        stmt = this.connection.createStatement();
        int count = 0;

        for(ResultSet rs4 = stmt.executeQuery("SELECT COUNT(user_id) AS csci FROM  Admin_login;"); rs4.next(); count = rs4.getInt("csci")) {
        }

        return count;
    }

    public int compcount() throws SQLException {
        Statement stmt;
        stmt = this.connection.createStatement();
        int count = 0;

        for(ResultSet rs5 = stmt.executeQuery("SELECT COUNT(comp_id ) AS comp FROM  computer_lab;"); rs5.next(); count = rs5.getInt("comp")) {
        }

        return count;
    }

    public void Insertuser(String pass, String name, String Email, String user) {
        String sql = "INSERT INTO Admin_login (user_id,Password,Email,user) VALUES(?,?,?,?)";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setString(1, name);
                pstmt.setString(2, pass);
                pstmt.setString(3, Email);
                pstmt.setString(4, user);
                pstmt.executeUpdate();
                System.out.println("data inserted user successfully");
            } catch (Throwable var10) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                    }
                }

                throw var10;
            }

            pstmt.close();
        } catch (SQLException var11) {
            System.out.println("failed to insert user data due to: " + var11.getMessage());
        }

    }

    public void Edituser(String pass, String Email, String sid) {
        String sql = "UPDATE Admin_login SET Password = ?,Email = ? WHERE user_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setString(1, pass);
                pstmt.setString(2, Email);
                pstmt.setString(3, sid);
                pstmt.executeUpdate();
                System.out.println("data user edited successfully");
            } catch (Throwable var9) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }
                }

                throw var9;
            }

            pstmt.close();
        } catch (SQLException var10) {
            System.out.println("failed to edit user data due to: " + var10.getMessage());
        }

    }

    public void Deluser(String sid) {
        String sql = "DELETE FROM Admin_login WHERE user_id=?";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setString(1, sid);
                pstmt.executeUpdate();
                System.out.println("data deleted user successfully");
            } catch (Throwable var7) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            pstmt.close();
        } catch (SQLException var8) {
            System.out.println("failed to delete user data due to: " + var8.getMessage());
        }

    }

    public ArrayList<usermodel> Retrieveuser(String user) {
        ArrayList<usermodel> sdata = new ArrayList<>();
        String sql = "SELECT * FROM Admin_login WHERE user =?;";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);

            try {
                pstmt.setString(1, user);
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()) {
                    sdata.add(new usermodel(rs.getString("user_id"), rs.getString("Password"), rs.getString("Email"), rs.getString("user")));
                }
            } catch (Throwable var8) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            pstmt.close();
        } catch (SQLException var9) {
            System.out.println(var9.getMessage());
        }

        return sdata;
    }

    public ArrayList<usermodel> Retrieveuser2() throws SQLException {
        ArrayList<usermodel> sdata = new ArrayList<>();
        Statement stmt;
        stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Admin_login;");

        while(rs.next()) {
            sdata.add(new usermodel(rs.getString("user_id"), rs.getString("Password"), rs.getString("Email"), rs.getString("user")));
            System.out.println(rs.getString("user_id")+" "+ rs.getString("Password"));
        }

        return sdata;
    }
}
