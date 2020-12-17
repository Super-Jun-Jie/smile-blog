package org.javatx.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/7 9:12
 */
public interface LogMapper extends JpaRepository<Log,Long>,JpaSpecificationExecutor<Log> {
}
