package com.noor.resource;

import com.noor.entity.Service;
import com.noor.service.ServiceService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/services")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceResource {

    @Inject
    ServiceService serviceService;

    @GET
    public Response getAll() {
        return Response.ok(serviceService.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return serviceService.findByIdOptional(id)
                .map(service -> Response.ok(service).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Service service) {
        service=serviceService.create(service);
        return Response.ok(service).build();
    }

    @PUT
    @Path("/{id}")
    public Response edit(@PathParam("id") Long id, Service service) {
        serviceService.update(service);
        return Response.ok(service).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = serviceService.deleteById(id);
        return deleted ? Response.noContent().build() 
                      : Response.status(Response.Status.NOT_FOUND).build();
    }
}
