package com.crq.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.crq.user.common.ResponseResult;
import com.crq.user.common.ResultCode;
import com.crq.user.domain.dto.UserDto;
import com.crq.user.domain.entity.User;
import com.crq.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:19
 */

@RestController
@Slf4j
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    @SentinelResource(value = "getUserById",blockHandler = "getUserBlock")
    public ResponseResult getUserById(@PathVariable Integer id) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return ResponseResult.success(userService.findById(id));
    }

    @PostMapping(value = "/login")
    public ResponseResult login(@RequestBody UserDto userDto) {
        User user = userService.login(userDto);
        if(user == null) {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        } else {
            return ResponseResult.success(user);
        }
    }

    public ResponseResult getUserBlock(BlockException exception) {
        log.info("接口被限流");
        log.info(exception.toString());
        return  ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
    }
}
