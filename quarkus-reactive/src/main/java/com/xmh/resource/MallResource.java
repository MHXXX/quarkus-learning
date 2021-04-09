package com.xmh.resource;

import com.xmh.entity.Mall;
import com.xmh.service.MallService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * .
 *
 * @author 谢明辉
 * @date 2021/3/19
 */
@Path("/malls")
@Produces(MediaType.APPLICATION_JSON)
public class MallResource {

    @Inject
    MallService mallService;

    @GET
    public Uni<Response> get(@QueryParam("size") Integer size, @QueryParam("page") Integer page) {
        return mallService.page(size, page)
                .onItem().transform(Response::ok)
                .onItem().transform(Response.ResponseBuilder::build);
    }

    @GET
    @Path("/{id}")
    public Uni<Mall> getById(@PathParam("id") Long id) {
        return mallService.getById(id);
    }

}
