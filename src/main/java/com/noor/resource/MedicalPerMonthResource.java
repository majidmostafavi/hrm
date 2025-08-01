package com.noor.resource;

import com.noor.dao.MedicalPerMonthRepository;
import com.noor.entity.MedicalPerMonth;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/medical-per-months")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalPerMonthResource {

    @Inject
    MedicalPerMonthRepository medicalPerMonthRepository;

    @GET
    public List<MedicalPerMonth> getAll() {
        return medicalPerMonthRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return medicalPerMonthRepository.findByIdOptional(id)
                .map(medical -> Response.ok(medical).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(MedicalPerMonth medicalPerMonth) {
        medicalPerMonthRepository.persist(medicalPerMonth);
        return Response.ok(medicalPerMonth).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = medicalPerMonthRepository.deleteById(id);
        return deleted ? Response.noContent().build() 
                      : Response.status(Response.Status.NOT_FOUND).build();
    }
}
