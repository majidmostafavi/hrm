package com.noor.resource;

import com.noor.entity.Organization;
import com.noor.service.OrganizationService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/organizations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganizationResource {

    @Inject
    OrganizationService organizationService;

    @GET
    public Response getAll() {
        return Response.ok(organizationService.listAll()).build();
    }


    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return organizationService.findByIdOptional(id)
                .map(service -> Response.ok(service).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Organization organization) {
        organization=organizationService.create(organization);
        return Response.ok(organization).build();
    }

    @PUT
    @Path("/{id}")
    public Response edit(@PathParam("id") Long id, Organization organization) {
        organizationService.update(organization);
        return Response.ok(organization).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = organizationService.deleteById(id);
        return deleted ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
