package com.ajaykumar.esd_project_backend.DAO;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Student;

import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student student);

    List<Student> getStudents();

    List<Course> getTACourses(Student student);
}
