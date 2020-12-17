package org.javatx.mapper;

import org.javatx.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/3 8:52
 */
public interface UserMapper extends JpaRepository<User,Long> , JpaSpecificationExecutor<User> {
    User findAllByUsername(String username);
}
