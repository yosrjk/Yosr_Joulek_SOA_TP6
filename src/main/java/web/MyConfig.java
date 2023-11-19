package web;

// Import statements for required classes and annotations
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

// Configuration annotation indicates that this class is a Spring configuration class
@Configuration
public class MyConfig extends ResourceConfig {

    // Constructor for the configuration class
    public MyConfig() {
        // Register the CompteRestJaxRSAPI class as a JAX-RS resource
        // This allows Jersey to recognize and manage the CompteRestJaxRSAPI as part of the RESTful service
        register(CompteRestJaxRSAPI.class);
    }
}
