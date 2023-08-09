package com.ajaykumar.esd_project_backend.DAO;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Student;

import java.util.List;

public interface CourseDAO {
    boolean addCourse(Course course);

    List<Course> getCourses();

    List<Student> getTAStudents(Course course);
}
