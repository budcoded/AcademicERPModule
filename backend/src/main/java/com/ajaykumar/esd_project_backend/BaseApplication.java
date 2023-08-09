package com.ajaykumar.esd_project_backend;

import com.ajaykumar.esd_project_backend.Util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class BaseApplication extends ResourceConfig {
    public BaseApplication () {
        // Registering the CORSFilter class with the Jersey ResourceConfig
        register(CORSFilter.class);

        // Telling Jersey the CLASSPATH where the specified classes (in our case, CORSFilter) can be found
        packages("com.ajaykumar.esd_project_backend");
    }
}