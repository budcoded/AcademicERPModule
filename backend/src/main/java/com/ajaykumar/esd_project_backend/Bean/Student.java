package com.ajaykumar.esd_project_backend.Bean;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(name = "roll_no", unique = true)
    private String rollNumber;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String emailId;
    @Column(name = "photograph_path")
    private String photographPath;
    @Column(name = "cgpa", nullable = false, columnDefinition = "float default 0.0")
    private float cgpa;
    @Column(name = "total_credits", nullable = false)
    private int totalCredits;
    @Column(name = "grad_year")
    private int graduationYear;

    @ManyToMany(fetch = FetchType.EAGER , mappedBy = "taStudentList" , cascade = {CascadeType.ALL})
    private List<Course> taCourseList = new ArrayList<>();

    public Student() {
    }

    public Student(String rollNumber, String firstName, String lastName, String emailId, String photographPath, float cgpa, int totalCredits, int graduationYear) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.photographPath = photographPath;
        this.cgpa = cgpa;
        this.totalCredits = totalCredits;
        this.graduationYear = graduationYear;
    }

    public Student(int studentId, String rollNumber, String firstName, String lastName, String emailId, String photographPath, float cgpa, int totalCredits, int graduationYear) {
        this.studentId = studentId;
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.photographPath = photographPath;
        this.cgpa = cgpa;
        this.totalCredits = totalCredits;
        this.graduationYear = graduationYear;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhotographPath() {
        return photographPath;
    }

    public void setPhotographPath(String photographPath) {
        this.photographPath = photographPath;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public List<Course> getTaCourseList() {
        return taCourseList;
    }

    public void setTaCourseList(List<Course> taCourseList) {
        this.taCourseList = taCourseList;
    }
}
