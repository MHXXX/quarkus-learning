package com.xmh.service;

import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

/**
 * .
 *
 * @author 谢明辉
 * @date 2021/3/19
 */
@ApplicationScoped
public class MainService {

    public Uni<String> hello(String name) {
        return Uni.createFrom().item(name).onItem().transform(n -> "hello " + name);
    }

}
