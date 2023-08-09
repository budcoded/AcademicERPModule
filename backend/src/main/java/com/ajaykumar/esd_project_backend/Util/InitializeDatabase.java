package com.ajaykumar.esd_project_backend.Util;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Faculty;
import com.ajaykumar.esd_project_backend.Bean.Student;
import com.ajaykumar.esd_project_backend.DAO.DAOImplementation.FacultyDAOImpl;
import com.ajaykumar.esd_project_backend.DAO.DAOImplementation.StudentDAOImpl;
import com.ajaykumar.esd_project_backend.DAO.FacultyDAO;
import com.ajaykumar.esd_project_backend.DAO.StudentDAO;

/**
 * This class is used for initializing the database
 */

public class InitializeDatabase {

    public static void main(String[] args) {
        // Adding dummy data into student table...
        addingIntoStudent();
        // Adding dummy data into faculty table and course table...
        addingFacultyAndCourses();
    }

    private static void addingFacultyAndCourses() {
        Faculty faculty1 = new Faculty();
        faculty1.setFirstName("Shyam");
        faculty1.setLastName("Singh");
        faculty1.setEmailId("Shyam.Singh@iiitb.ac.in");
        faculty1.setPassword("password");
        faculty1.setTitle("Assistant Professor");
        faculty1.setPhotographPath("NA");

//        Faculty faculty2 = new Faculty();
//        faculty2.setFirstName("Ram");
//        faculty2.setLastName("Singh");
//        faculty2.setEmailId("Ram.Singh@iiitb.ac.in");
//        faculty2.setPassword("password");
//        faculty2.setTitle("Senior Professor");
//        faculty2.setPhotographPath("NA");

        Course course1 = new Course();
        course1.setCourseCode("CS511");
        course1.setCourseName("Algorithms - 1");
        course1.setDescription("Advance Algorithms");
        course1.setYear(1);
        course1.setTerm(1);
        course1.setCredits(4);
        course1.setCapacity(150);

        Course course2 = new Course();
        course2.setCourseCode("CS512");
        course2.setCourseName("Software Systems");
        course2.setDescription("Learning Ubuntu");
        course2.setYear(1);
        course2.setTerm(1);
        course2.setCredits(4);
        course2.setCapacity(150);

        Course course3 = new Course();
        course3.setCourseCode("CS513");
        course3.setCourseName("Machine Learning");
        course3.setDescription("Learning ML Algorithms");
        course3.setYear(1);
        course3.setTerm(1);
        course3.setCredits(4);
        course3.setCapacity(150);

        Course course4 = new Course();
        course4.setCourseCode("CS514");
        course4.setCourseName("MML");
        course4.setDescription("Maths for machine learning");
        course4.setYear(1);
        course4.setTerm(1);
        course4.setCredits(4);
        course4.setCapacity(150);

        Course course5 = new Course();
        course5.setCourseCode("CS515");
        course5.setCourseName("Discrete Maths");
        course5.setDescription("Discrete Mathematics");
        course5.setYear(1);
        course5.setTerm(1);
        course5.setCredits(4);
        course5.setCapacity(150);

        Course course6 = new Course();
        course6.setCourseCode("CS516");
        course6.setCourseName("Digital Communication");
        course6.setDescription("Communication");
        course6.setYear(1);
        course6.setTerm(1);
        course6.setCredits(4);
        course6.setCapacity(150);

        faculty1.getCourseList().add(course1);
        faculty1.getCourseList().add(course2);
        faculty1.getCourseList().add(course3);
        faculty1.getCourseList().add(course4);
        faculty1.getCourseList().add(course5);
        faculty1.getCourseList().add(course6);

        course1.setFaculty(faculty1);
        course2.setFaculty(faculty1);
        course3.setFaculty(faculty1);
        course4.setFaculty(faculty1);
        course5.setFaculty(faculty1);
        course6.setFaculty(faculty1);

        FacultyDAO facultyDAO = new FacultyDAOImpl();
        if (facultyDAO.addFaculty(faculty1)) {
            System.out.println("Faculty and courses added successfully.");
        } else {
            System.err.println("Error while adding faculty.");
        }
//        if (facultyDAO.addFaculty(faculty2)) {
//            System.out.println("Faculty and courses added successfully.");
//        } else {
//            System.err.println("Error while adding faculty.");
//        }
    }

    private static void addingIntoStudent() {
        StudentDAO studentDAO = new StudentDAOImpl();

        Student student1 = new Student();
        student1.setRollNumber("MT2022007");
        student1.setFirstName("Ajay");
        student1.setLastName("Kumar");
        student1.setEmailId("Ajay.Kumar@iiitb.ac.in");
        student1.setCgpa(2.93f);
        student1.setTotalCredits(4);
        student1.setGraduationYear(2024);
        student1.setPhotographPath("NA");
        if (studentDAO.addStudent(student1)) {
            System.out.println("Student-1 Added Successfully.");
        } else {
            System.err.println("Error in adding Student-1.");
        }

        Student student2 = new Student();
        student2.setRollNumber("MT2022006");
        student2.setFirstName("Adwait");
        student2.setLastName("Upadhyay");
        student2.setEmailId("Adwait.Upadhyay@iiitb.ac.in");
        student2.setCgpa(3.45f);
        student2.setTotalCredits(4);
        student2.setGraduationYear(2024);
        student2.setPhotographPath("NA");
        if (studentDAO.addStudent(student2)) {
            System.out.println("Student-2 Added Successfully.");
        } else {
            System.err.println("Error in adding Student-2.");
        }

        Student student3 = new Student();
        student3.setRollNumber("MT2022143");
        student3.setFirstName("Anshul");
        student3.setLastName("Sharma");
        student3.setEmailId("Anshul.Sharma@iiitb.ac.in");
        student3.setCgpa(3.00f);
        student3.setTotalCredits(4);
        student3.setGraduationYear(2024);
        student3.setPhotographPath("NA");
        if (studentDAO.addStudent(student3)) {
            System.out.println("Student-3 Added Successfully.");
        } else {
            System.err.println("Error in adding Student-3.");
        }

        Student student4 = new Student();
        student4.setRollNumber("MT2022008");
        student4.setFirstName("Anshul1");
        student4.setLastName("Sharma1");
        student4.setEmailId("Anshul1.Sharma1@iiitb.ac.in");
        student4.setCgpa(3.50f);
        student4.setTotalCredits(4);
        student4.setGraduationYear(2024);
        student4.setPhotographPath("NA");
        if (studentDAO.addStudent(student4)) {
            System.out.println("Student-4 Added Successfully.");
        } else {
            System.err.println("Error in adding Student-4.");
        }

        Student student5 = new Student();
        student5.setRollNumber("MT2022109");
        student5.setFirstName("Anshul2");
        student5.setLastName("Sharma2");
        student5.setEmailId("Anshul2.Sharma2@iiitb.ac.in");
        student5.setCgpa(3.23f);
        student5.setTotalCredits(4);
        student5.setGraduationYear(2024);
        student5.setPhotographPath("NA");
        if (studentDAO.addStudent(student5)) {
            System.out.println("Student-5 Added Successfully.");
        } else {
            System.err.println("Error in adding Student-5.");
        }

        Student student6 = new Student();
        student6.setRollNumber("MT2022110");
        student6.setFirstName("Anshul3");
        student6.setLastName("Sharma3");
        student6.setEmailId("Anshul3.Sharma3@iiitb.ac.in");
        student6.setCgpa(3.67f);
        student6.setTotalCredits(4);
        student6.setGraduationYear(2024);
        student6.setPhotographPath("NA");
        if (studentDAO.addStudent(student6)) {
            System.out.println("Student-6 Added Successfully.");
        } else {
            System.err.println("Error in adding Student-6.");
        }
    }
}