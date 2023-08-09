package com.ajaykumar.esd_project_backend.Bean;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;
    @Column(name = "course_name", nullable = false)
    private String courseName;
    @Column(name = "description")
    private String description;
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "term", nullable = false)
    private int term;
    @Column(name = "credits", nullable = false)
    private int credits;
    @Column(name = "capacity", nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Student.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "student_course_ta", joinColumns = {@JoinColumn(name = "course_id")}, inverseJoinColumns = {@JoinColumn(name = "student_id")}, uniqueConstraints = @UniqueConstraint(columnNames = {"course_id", "student_id"}))
    private List<Student> taStudentList = new ArrayList<>();

    public Course() {
    }

    public Course(String courseCode, String courseName, String description, int year, int term, int credits, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
    }

    public Course(String courseCode, String courseName, String description, int year, int term, int credits, int capacity, Faculty faculty) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
        this.faculty = faculty;
    }

    public Course(int courseId, String courseCode, String courseName, String description, int year, int term, int credits, int capacity) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Student> getTaStudentList() {
        return taStudentList;
    }

    public void setTaStudentList(List<Student> taStudentList) {
        this.taStudentList = taStudentList;
    }
}
