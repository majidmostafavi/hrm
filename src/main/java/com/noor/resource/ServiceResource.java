package com.noor.resource;

import com.noor.dao.ServiceRepository;
import com.noor.entity.Service;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/services")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceResource {

    @Inject
    ServiceRepository serviceRepository;

    @GET
    public List<Service> getAll() {
        return serviceRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return serviceRepository.findByIdOptional(id)
                .map(service -> Response.ok(service).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Service service) {
        serviceRepository.persist(service);
        return Response.ok(service).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = serviceRepository.deleteById(id);
        return deleted ? Response.noContent().build() 
                      : Response.status(Response.Status.NOT_FOUND).build();
    }
}
