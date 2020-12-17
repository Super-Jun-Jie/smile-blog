package org.javatx.service.impl;

import org.javatx.mapper.UserMapper;
import org.javatx.pojo.User;
import org.javatx.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/3 8:52
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findAllByUsername(username);
    }
}
