package com.noor.resource;

import com.noor.entity.Year;
import com.noor.service.YearService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/years")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class YearResource {

    @Inject
    YearService yearService;

    @GET
    public Response getAll() {
        return Response.ok(yearService.listAll()).build();
    }

    @POST
    @Transactional
    public Response create(Year year) {
        year=yearService.create(year);
        return Response.ok(year).build();
    }

    @PUT
    @Path("/{id}")
    public Response edit(@PathParam("id") Long id, Year year) {
        yearService.update(year);
        return Response.ok(year).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = yearService.deleteById(id);
        return deleted ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
