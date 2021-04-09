package com.xmh.service;

import com.xmh.entity.Mall;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * .
 *
 * @author 谢明辉
 * @date 2021/3/19
 */

@ApplicationScoped
public class MallService {

    PgPool client;

    public MallService(PgPool client) {
        this.client = client;
    }

    public Uni<List<Mall>> page(int size, int page) {
        int offset = (page - 1) * size;

        return client.preparedQuery("select * from b_mall order by id offset $1 limit $2").execute(Tuple.of(offset, size))
                .map(x -> {
                            LinkedList<Mall> list = new LinkedList<>();
                            x.forEach(a -> list.add(from(a)));
                            return list;
                        }
                );

    }

    public Uni<Mall> getById(long id) {
        return client.preparedQuery("select * from b_mall where id=$1").execute(Tuple.of(id))
                .onItem().transform(RowSet::iterator)
                .onItem().transform(x -> x.hasNext() ? from(x.next()) : null);
    }

    public Mall from(Row row) {
        Mall mall = new Mall();
        mall.setId(row.getLong("id"));
        mall.setName(row.getString("name"));
        mall.setOpenDate(row.getLocalDate("open_date"));
        return mall;
    }

}
