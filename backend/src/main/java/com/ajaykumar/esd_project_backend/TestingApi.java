package com.ajaykumar.esd_project_backend;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/testing")
public class TestingApi {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hell Yeah! This is working..";
    }
}