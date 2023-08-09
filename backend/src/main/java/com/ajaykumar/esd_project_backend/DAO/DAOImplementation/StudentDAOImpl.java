package com.ajaykumar.esd_project_backend.DAO.DAOImplementation;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Student;
import com.ajaykumar.esd_project_backend.DAO.StudentDAO;
import com.ajaykumar.esd_project_backend.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean addStudent(Student student) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            return true;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in Adding Student: " + hibernateException.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Student> getStudents() {
        try (Session session = HibernateSessionUtil.getSession()) {
            List<Student> students = new ArrayList<>(session.createQuery("from Student", Student.class).list());
            List<Student> result = new ArrayList<>();
            for (Student object : students) {
                Student student = new Student(object.getStudentId(), object.getRollNumber(), object.getFirstName(), object.getLastName(), object.getEmailId(), object.getPhotographPath(), object.getCgpa(), object.getTotalCredits(), object.getGraduationYear());

                List<Course> list = new ArrayList<>();
                for (Course obj : object.getTaCourseList()) {
                    Course ob = new Course(obj.getCourseId(), obj.getCourseCode(), obj.getCourseName(), obj.getDescription(), obj.getYear(), obj.getTerm(), obj.getCredits(), obj.getCapacity());
                    list.add(ob);
                }

                student.getTaCourseList().addAll(list);
                result.add(student);
            }
            return result;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in Getting Students: " + hibernateException.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Course> getTACourses(Student student) {
        try (Session session = HibernateSessionUtil.getSession()) {
            int studentId = student.getStudentId();
            List<Student> result = new ArrayList<>(session.createQuery("from Student where id =: student_id", Student.class).setParameter("student_id", studentId).list());
            if (result.size() == 0) {
                return null;
            }
            Student object = result.get(0);
            List<Course> list = new ArrayList<>();
            for (Course obj : object.getTaCourseList()) {
                Course res = new Course();
                res.setCourseId(obj.getCourseId());
                res.setCourseCode(obj.getCourseCode());
                res.setCourseName(obj.getCourseName());
                res.setDescription(obj.getDescription());
                res.setYear(obj.getYear());
                res.setTerm(obj.getTerm());
                res.setCredits(obj.getCredits());
                res.setCapacity(obj.getCapacity());
                list.add(res);
            }
            return list;
        } catch (HibernateException hibernateException) {
            System.err.println("Exception in getting TA courses: ".concat(hibernateException.getLocalizedMessage()));
            return null;
        }
    }
}