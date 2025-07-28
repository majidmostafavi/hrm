package com.noor.resource;

import com.noor.dao.MonthRepository;
import com.noor.entity.Month;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/months")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MonthResource {

    @Inject
    MonthRepository monthRepository;

    @GET
    public List<Month> getAll() {
        return monthRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return monthRepository.findByIdOptional(id)
                .map(month -> Response.ok(month).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Month month) {
        monthRepository.persist(month);
        return Response.ok(month).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = monthRepository.deleteById(id);
        return deleted ? Response.noContent().build() 
                      : Response.status(Response.Status.NOT_FOUND).build();
    }
}
