package com.noor.resource;

import com.noor.entity.Category;
import com.noor.service.CategoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @GET
    public Response getALL() {
        categoryService.findAllCategory();
        return Response.ok( categoryService.findAllCategory()).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return categoryService.findByIdOptional(id)
                .map(service -> Response.ok(service).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    public Response create(Category category) {
        category=categoryService.create(category);
        return Response.ok(category).build();
    }

    @PUT
    @Path("/{id}")
    public Response edit(@PathParam("id") Long id, Category category) {
        categoryService.update(category);
        return Response.ok(category).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = categoryService.deleteById(id);
        return deleted ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
