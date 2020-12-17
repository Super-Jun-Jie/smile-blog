package org.javatx.service;

import org.javatx.pojo.Carousel;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 11:42
 */
public interface CarouselService {
    void save(Carousel carousel);

    Page<Carousel> search(Carousel carousel, int page, Integer limit);

    void deleteById(Long id);

    List<Carousel> findAll();
}
