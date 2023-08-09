package com.ajaykumar.esd_project_backend.Controller;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Student;
import com.ajaykumar.esd_project_backend.DAO.CourseDAO;
import com.ajaykumar.esd_project_backend.DAO.DAOImplementation.CourseDAOImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/course")
public class CourseController {
    CourseDAO courseDAO = new CourseDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(Course course) {
        if (this.courseDAO.addCourse(course)) {
            return Response.status(200).entity("Course Added Successfully.").build();
        } else {
            return Response.status(404).entity("Failure while adding course.").build();
        }
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourses() {
        List<Course> courses = this.courseDAO.getCourses();
        if (courses == null)
            return Response.status(400).build();
        return Response.status(200).entity(courses).build();
    }

    @POST
    @Path("/getTAStudents")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTAStudents (Course course) {
        List<Student> students = this.courseDAO.getTAStudents(course);
        if (students == null)
            return Response.status(400).build();
        return Response.status(200).entity(students).build();
    }
}