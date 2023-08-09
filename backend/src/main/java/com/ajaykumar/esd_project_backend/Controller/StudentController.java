package com.ajaykumar.esd_project_backend.Controller;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Student;
import com.ajaykumar.esd_project_backend.DAO.DAOImplementation.StudentDAOImpl;
import com.ajaykumar.esd_project_backend.DAO.StudentDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/student")
public class StudentController {
    StudentDAO studentDAO = new StudentDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent (Student student) {
        if (this.studentDAO.addStudent(student)) {
            return Response.status(200).entity("Student Added Successfully.").build();
        } else {
            return Response.status(404).entity("Failure while adding student.").build();
        }
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents () {
        List<Student> students = this.studentDAO.getStudents();
        return Response.status(200).entity(students).build();
    }

    @POST
    @Path("/getTACourses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTACourses (Student student) {
        List<Course> courses = this.studentDAO.getTACourses(student);
        if (courses == null)
            return Response.status(400).build();
        return Response.status(200).entity(courses).build();
    }
}
