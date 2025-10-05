package com.noor.resource;

import com.noor.dto.OccupationDTO;
import com.noor.entity.Occupation;
import com.noor.mapper.OccupationMapper;
import com.noor.service.OccupationService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/occupations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OccupationResource {


    @Inject
    OccupationService occupationService;

    @GET
    public Response getAll() {
        return Response.ok(occupationService.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return occupationService.findByIdOptional(id)
                .map(occupation -> Response.ok(occupation).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Occupation occupation) {
     //   Occupation occupation = OccupationMapper.convertDtoToEntity(occupationDTO);
        occupation=occupationService.create(occupation);
        return Response.ok(occupation).build();
    }

    @PUT
    @Path("/{id}")
    public Response edit(@PathParam("id") Long id, Occupation occupation) {
        occupationService.update(occupation);
        return Response.ok(occupation).build();
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = occupationService.deleteById(id);
        return deleted ? Response.noContent().build() 
                      : Response.status(Response.Status.NOT_FOUND).build();
    }
}
