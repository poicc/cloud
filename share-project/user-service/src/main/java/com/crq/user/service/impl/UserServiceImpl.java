package com.crq.user.service.impl;

import com.crq.user.domain.dto.UserDto;
import com.crq.user.domain.entity.User;
import com.crq.user.repository.UserRepository;
import com.crq.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Base64;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 14:15
 */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User login(UserDto userDto) {
        return userRepository.findByMobileAndPassword(userDto.getMobile(), DigestUtils.md5Hex(userDto.getPassword()));
    }
}
