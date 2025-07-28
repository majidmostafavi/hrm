package com.noor.resource;

import com.noor.dao.PersonnelAttendanceRepository;
import com.noor.entity.PersonnelAttendance;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/personnel-attendances")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonnelAttendanceResource {

    @Inject
    PersonnelAttendanceRepository personnelAttendanceRepository;

    @GET
    public List<PersonnelAttendance> getAll() {
        return personnelAttendanceRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return personnelAttendanceRepository.findByIdOptional(id)
                .map(attendance -> Response.ok(attendance).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(PersonnelAttendance attendance) {
        personnelAttendanceRepository.persist(attendance);
        return Response.ok(attendance).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = personnelAttendanceRepository.deleteById(id);
        if (deleted)
            return Response.noContent().build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
