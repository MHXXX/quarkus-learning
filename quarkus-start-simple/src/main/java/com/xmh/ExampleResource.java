package com.xmh;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * .
 *
 * @author 谢明辉
 * @date 2021/4/9
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @GET
    public String hello() {
        return "quarkus hello world!";
    }

}
