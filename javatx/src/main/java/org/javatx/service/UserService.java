package org.javatx.service;

import org.javatx.pojo.User;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/3 8:51
 */
public interface UserService {
    User findByUsername(String username);
}
