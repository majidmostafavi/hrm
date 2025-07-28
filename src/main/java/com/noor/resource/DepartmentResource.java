package com.noor.resource;

import com.noor.dao.DepartmentRepository;
import com.noor.entity.Department;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    DepartmentRepository departmentRepository;

    @GET
    public List<Department> getAll() {
        return departmentRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return departmentRepository.findByIdOptional(id)
                .map(department -> Response.ok(department).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Department person) {
        departmentRepository.persist(person);
        return Response.ok(person).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = departmentRepository.deleteById(id);
        if (deleted)
            return Response.noContent().build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}