package web;

// Import statements for required classes and annotations
import entities.Compte;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.CompteRepository;

import java.util.List;

// Component annotation indicates that this class is a Spring component
@Component
// Path annotation specifies the base path for this JAX-RS resource
@Path("/comptes")
public class CompteRestJaxRSAPI {

    // Autowired's annotation injects the CompteRepository bean into this class
    @Autowired
    private CompteRepository compteRepository;

    // HTTP GET method to retrieve a list of Comptes in JSON format
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> compteList() {
        return compteRepository.findAll();
    }

    // HTTP GET method to retrieve a specific Compte by its ID in JSON format
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getOne(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    // HTTP POST method to create a new Compte using JSON data and return the created Compte in JSON format
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Compte compte) {
        // Save the new Compte using the CompteRepository
        Compte createdCompte = compteRepository.save(compte);
        // Return a response with the created Compte in the body and a status of 201 (Created)
        return Response.status(Response.Status.CREATED).entity(createdCompte).build();
    }

    // HTTP PUT method to update an existing Compte using JSON data and return the updated Compte in JSON format
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Compte compte, @PathParam("id") Long id) {
        // Find the existing Compte by ID
        Compte existingCompte = compteRepository.findById(id).orElse(null);

        // If the Compte exists, update its properties with the values from the provided Compte
        if (existingCompte != null) {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setEtat(compte.getEtat());
            existingCompte.setType(compte.getType());

            // Save the updated Compte using the CompteRepository
            compteRepository.save(existingCompte);

            // Return a response with the updated Compte in the body and a status of 200 (OK)
            return Response.ok(existingCompte).build();
        } else {
            // If the Compte does not exist, return a response with a status of 404 (Not Found)
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // HTTP DELETE method to delete a Compte by its ID and return the deleted Compte in JSON format
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        // Find the existing Compte by ID
        Compte existingCompte = compteRepository.findById(id).orElse(null);

        // If the Compte exists, delete it using the CompteRepository
        if (existingCompte != null) {
            compteRepository.deleteById(id);
            // Return a response with the deleted Compte in the body and a status of 200 (OK)
            return Response.ok(existingCompte).build();
        } else {
            // If the Compte does not exist, return a response with a status of 404 (Not Found)
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
