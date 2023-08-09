package com.ajaykumar.esd_project_backend.Bean;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {
    @Id
    @Column(name = "faculty_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facultyId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;
    @Column(name = "password")
    private String password;
    @Column(name = "title")
    private String title;
    @Column(name = "photograph_path")
    private String photographPath;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    private List<Course> courseList = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(String firstName, String lastName, String emailId, String password, String title, String photographPath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.title = title;
        this.photographPath = photographPath;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotographPath() {
        return photographPath;
    }

    public void setPhotographPath(String photographPath) {
        this.photographPath = photographPath;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
