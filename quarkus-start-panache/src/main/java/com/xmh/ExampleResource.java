package com.xmh;

import com.xmh.entity.Person;

import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;

/**
 * .
 *
 * @author 谢明辉
 * @date 2021/4/9
 */
@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @GET
    public List<Person> hello() {
        return Person.listAll();
    }

    @GET
    @Path(("/{id}"))
    public Person getPerson(@PathParam("id") Long id) {
        return Person.findById(id);
    }

    @GET
    @Path("count")
    public Long count() {
        return Person.count();
    }

    @POST
    @Transactional(rollbackOn = Exception.class)
    public Person add(Person person) {
        person.persistAndFlush();
        return person;
    }

    @DELETE
    @Path("/{id}")
    @Transactional(rollbackOn = Exception.class)
    public boolean delete(@PathParam("id") Long id) {
        return Person.deleteById(id);
    }

    @PUT
    @Transactional(rollbackOn = Exception.class)
    public Person update(Person person) {
        HashMap<String, Object> params = new HashMap<>();
        StringBuilder sb = new StringBuilder("set ");
        if (person.name != null) {
            sb.append("name = :name,");
            params.put("name", person.name);
        }
        if (person.gender != null) {
            sb.append("gender= :gender,");
            params.put("gender", person.gender);
        }
        if (person.birth != null) {
            sb.append("birth = :birth,");
            params.put("birth", person.birth);
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(" where id=:id");
        params.put("id", person.id);

        Person.update(sb.toString(), params);
        return Person.findById(person.id);
    }
}
