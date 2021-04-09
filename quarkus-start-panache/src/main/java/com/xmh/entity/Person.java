package com.xmh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * .
 *
 * @author 谢明辉
 * @date 2021/4/9
 */

/**
 * 广场/商场表
 */
@Entity
public class Person extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public LocalDate birth;
    public Short gender;

}