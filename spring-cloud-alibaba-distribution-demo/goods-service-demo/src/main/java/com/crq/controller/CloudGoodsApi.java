package com.crq.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/25 14:56
 */
@RestController
public class CloudGoodsApi {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @PutMapping("/goods/{goodsId}")
    public Boolean deStock(@PathVariable("goodsId") int goodsId) {
        // 减库存操作
        int result = jdbcTemplate.update("update tb_goods set goods_stock=goods_stock-1 where goods_id=" + goodsId);
        return result > 0;
    }
}