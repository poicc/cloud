package com.crq.user.service;

import com.crq.user.domain.dto.UserDto;
import com.crq.user.domain.entity.User;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:14
 */

public interface UserService {
    /**
     * 根据id找user
     * @param id id
     * @return user
     */
    User findById(Integer id);

    /**
     * 登录
     * @param userDto userDto
     * @return user
     */
    User login(UserDto userDto);
}
