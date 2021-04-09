package com.xmh.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * .
 *
 * @author 谢明辉
 * @date 2021/3/19
 */
@Data
public class Mall {

    private Long id;
    private String name;
    private LocalDate openDate;
}
