package com.noor.resource;

import com.noor.entity.MedicalPerMonth;
import com.noor.entity.MedicalPerMonthMaster;
import com.noor.service.MedicalPerMonthService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/medical-per-months")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalPerMonthResource {

    @Inject
    MedicalPerMonthService medicalPerMonthService;

    @GET
    public Response getAll() {
        return Response.ok(medicalPerMonthService.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return medicalPerMonthService.findById(id)
                .map(medical -> Response.ok(medical).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(MedicalPerMonthMaster medicalPerMonth) {
        medicalPerMonthService.create(medicalPerMonth);
        return Response.ok(medicalPerMonth).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = medicalPerMonthService.delete(id);
        return deleted ? Response.noContent().build() 
                      : Response.status(Response.Status.NOT_FOUND).build();
    }
}
