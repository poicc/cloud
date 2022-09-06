package com.crq.content.openfeign;

import com.crq.content.common.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:54
 */
@FeignClient(value = "user-center",path = "/user")
public interface UserService {
    /**
     * 根据id查询用户
     * @param id id
     * @return ResponseResult
     */
    @GetMapping("{id}")
    ResponseResult getUser(@PathVariable(value="id") int id);
}
