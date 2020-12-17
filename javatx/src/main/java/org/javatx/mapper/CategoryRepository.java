package org.javatx.mapper;

import org.javatx.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 11:07
 */
public interface CategoryRepository extends JpaRepository<Category,Long> , JpaSpecificationExecutor<Category> {
}
