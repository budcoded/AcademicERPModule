package com.ajaykumar.esd_project_backend.DAO.DAOImplementation;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Student;
import com.ajaykumar.esd_project_backend.DAO.CourseDAO;
import com.ajaykumar.esd_project_backend.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean addCourse(Course course) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
            return true;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in Adding Student: " + hibernateException.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Course> getCourses() {
        try (Session session = HibernateSessionUtil.getSession()) {
            List<Course> result = new ArrayList<>(session.createQuery("from Course ", Course.class).list());

            for (Course course : result) {
                course.getFaculty().getCourseList().clear();
                for (Student val : course.getTaStudentList())
                    val.getTaCourseList().clear();
            }
            return result;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in Getting Courses: " + hibernateException.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Student> getTAStudents(Course course) {
        try (Session session = HibernateSessionUtil.getSession()) {
            int courseId = course.getCourseId();
            List<Course> result = new ArrayList<>(session.createQuery("from Course where id =: course_id", Course.class).setParameter("course_id", courseId).list());
            if (result.size() == 0) {
                return null;
            }
            Course object = result.get(0);
            List<Student> list = new ArrayList<>();
            for (Student obj : object.getTaStudentList()) {
                Student res = new Student();
                res.setStudentId(obj.getStudentId());
                res.setRollNumber(obj.getRollNumber());
                res.setFirstName(obj.getFirstName());
                res.setLastName(obj.getLastName());
                res.setEmailId(obj.getEmailId());
                res.setPhotographPath(obj.getPhotographPath());
                res.setCgpa(obj.getCgpa());
                res.setTotalCredits(obj.getTotalCredits());
                res.setGraduationYear(obj.getGraduationYear());
                list.add(res);
            }
            return list;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in getting TA students: ".concat(hibernateException.getLocalizedMessage()));
            return null;
        }
    }
}
