package com.ajaykumar.esd_project_backend.Controller;

import com.ajaykumar.esd_project_backend.Bean.Course;
import com.ajaykumar.esd_project_backend.Bean.Faculty;
import com.ajaykumar.esd_project_backend.DAO.DAOImplementation.FacultyDAOImpl;
import com.ajaykumar.esd_project_backend.DAO.FacultyDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/faculty")
public class FacultyController {
    FacultyDAO facultyDAO = new FacultyDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFaculty(Faculty faculty) {
        if (this.facultyDAO.addFaculty(faculty)) {
            return Response.status(200).entity("Faculty Added Successfully.").build();
        } else {
            return Response.status(404).entity("Failure while adding faculty.").build();
        }
    }

    @GET
    @Path("/getFacultyList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFacultyList() {
        List<Faculty> faculties = this.facultyDAO.getFacultyList();
        if (faculties == null)
            return Response.status(400).build();
        else
            return Response.status(200).entity(faculties).build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginFaculty(Faculty faculty) {
        Faculty loggedInFaculty = facultyDAO.loginFaculty(faculty);

        if (loggedInFaculty == null) {
            return Response.status(401).build();
        } else {
            return Response.ok().entity(loggedInFaculty).build();
        }
    }

    @POST
    @Path("/addTA")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addingTA(@QueryParam("student_id") int studentId, @QueryParam("course_id") int courseId) {
        if (facultyDAO.addTA(studentId, courseId)) {
            return Response.status(200).entity("Success").build();
        } else {
            return Response.status(404).entity("Failure").build();
        }
    }

//    @POST
//    @Path("/facultyCourses")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response facultyCourses(@QueryParam("faculty_id") int facultyId) {
//        List<Course> courseList = facultyDAO.facultyCourses(facultyId);
//        if (courseList != null) {
//            return Response.ok().entity(courseList).build();
//        } else {
//            return Response.status(404).entity("Failure").build();
//        }
//    }
}