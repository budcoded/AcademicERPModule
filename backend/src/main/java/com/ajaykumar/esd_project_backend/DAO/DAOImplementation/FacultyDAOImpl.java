package com.ajaykumar.esd_project_backend.DAO.DAOImplementation;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Faculty;
import com.ajaykumar.esd_project_backend.Bean.Student;
import com.ajaykumar.esd_project_backend.DAO.FacultyDAO;
import com.ajaykumar.esd_project_backend.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {
    @Override
    public boolean addFaculty(Faculty faculty) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(faculty);
            transaction.commit();
            return true;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in Adding Student: " + hibernateException.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Faculty loginFaculty(Faculty faculty) {
        try (Session session = HibernateSessionUtil.getSession()) {
            String facultyEmail = faculty.getEmailId();
            String facultyPassword = faculty.getPassword();

            List<Faculty> result = new ArrayList<>(
                    session.createQuery("from Faculty where emailId =: email and password =: password", Faculty.class)
                            .setParameter("email", facultyEmail)
                            .setParameter("password", facultyPassword)
                            .list()
            );

            if (result.size() == 0) {
                return null;
            } else {
                List<Course> updatedList = new ArrayList<>();
                List<Course> list = result.get(0).getCourseList();
                for (Course course : list) {
                    Course object = new Course();
                    object.setTerm(course.getTerm());
                    object.setCapacity(course.getCapacity());
                    object.setYear(course.getYear());
                    object.setCredits(course.getCredits());
                    object.setDescription(course.getDescription());
                    object.setCourseName(course.getCourseName());
                    object.setCourseCode(course.getCourseCode());
                    updatedList.add(object);
                }

                result.get(0).getCourseList().clear();
                result.get(0).getCourseList().addAll(updatedList);
                return result.get(0);
            }
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in Logging In Faculty: " + hibernateException.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Faculty> getFacultyList() {
        try (Session session = HibernateSessionUtil.getSession()) {
            List<Faculty> result = new ArrayList<>(session.createQuery("from Faculty", Faculty.class).list());

            if (result.size() == 0) {
                return null;
            } else {
//                List<Faculty> facultyList = new ArrayList<>();
                for (Faculty faculty : result) {
                    List<Course> updatedList = new ArrayList<>();
                    List<Course> list = faculty.getCourseList();
                    for (Course course : list) {
                        Course object = new Course();
                        object.setTerm(course.getTerm());
                        object.setCapacity(course.getCapacity());
                        object.setYear(course.getYear());
                        object.setCredits(course.getCredits());
                        object.setDescription(course.getDescription());
                        object.setCourseName(course.getCourseName());
                        object.setCourseCode(course.getCourseCode());
                        updatedList.add(object);
                    }

                    faculty.getCourseList().clear();
                    faculty.getCourseList().addAll(updatedList);

//                    facultyList.add(faculty);
                }

                return result;
            }
        } catch (HibernateException hibernateException) {
            System.out.println("Exception while getting faculty list: ".concat(hibernateException.getLocalizedMessage()));
            return null;
        }
    }

    @Override
    public boolean addTA(int studentId, int courseId) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.load(Student.class, studentId);
            Course course = session.load(Course.class, courseId);

            student.getTaCourseList().add(course);
            course.getTaStudentList().add(student);
            session.update(student);
            session.update(course);
            transaction.commit();
            return true;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in adding TA: " + hibernateException.getLocalizedMessage());
            return false;
        }
    }

//    @Override
//    public List<Course> facultyCourses(int facultyId) {
//        try (Session session = HibernateSessionUtil.getSession()) {
//            Transaction transaction = session.beginTransaction();
//            Faculty faculty = session.load(Faculty.class, facultyId);
//
//            List<Course> result = faculty.getCourseList();
//            for (Course course : result) {
//                course.getFaculty().getCourseList().clear();
//                for (Student val : course.getTaStudentList())
//                    val.getTaCourseList().clear();
//            }
//            transaction.commit();
//            return result;
//        } catch (HibernateException hibernateException) {
//            System.err.println("Exception in fetching courses: ".concat(hibernateException.getLocalizedMessage()));
//            return null;
//        }
//    }
}
