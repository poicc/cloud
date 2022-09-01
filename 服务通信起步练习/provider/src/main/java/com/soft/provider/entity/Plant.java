package com.soft.provider.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: crq
 * @description:
 * @date: 2022/8/30 16:41
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
    private String name;
    private String des;
    private double price;
    private Integer num;
}
