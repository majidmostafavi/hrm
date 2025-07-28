package com.noor.resource;

import com.noor.dao.OccupationRepository;
import com.noor.entity.Occupation;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/occupations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OccupationResource {

    @Inject
    OccupationRepository occupationRepository;

    @GET
    public List<Occupation> getAll() {
        return occupationRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return occupationRepository.findByIdOptional(id)
                .map(occupation -> Response.ok(occupation).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Occupation occupation) {
        occupationRepository.persist(occupation);
        return Response.ok(occupation).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = occupationRepository.deleteById(id);
        return deleted ? Response.noContent().build() 
                      : Response.status(Response.Status.NOT_FOUND).build();
    }
}
