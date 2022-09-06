package com.crq.content.service;

import com.crq.content.domain.entity.Share;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:42
 */
public interface ShareService {

    /**
     * 根据id查找
     * @param id id
     * @return share
     */
    Share findById(Integer id);
}
