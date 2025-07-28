package com.noor.resource;

import com.noor.dao.OrganizationRepository;
import com.noor.entity.Organization;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/organizations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganizationResource {

    @Inject
    OrganizationRepository organizationRepository;

    @GET
    public List<Organization> getAll() {
        return organizationRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return organizationRepository.findByIdOptional(id)
                .map(organization -> Response.ok(organization).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Organization organization) {
        organizationRepository.persist(organization);
        return Response.ok(organization).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = organizationRepository.deleteById(id);
        return deleted ? Response.noContent().build() 
                      : Response.status(Response.Status.NOT_FOUND).build();
    }
}
