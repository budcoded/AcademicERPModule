package com.ajaykumar.esd_project_backend.DAO;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Faculty;

import java.util.List;

public interface FacultyDAO {
    boolean addFaculty(Faculty faculty);
    Faculty loginFaculty(Faculty faculty);

    List<Faculty> getFacultyList();

    boolean addTA(int studentId, int courseId);

//    List<Course> facultyCourses(int facultyId);
}
