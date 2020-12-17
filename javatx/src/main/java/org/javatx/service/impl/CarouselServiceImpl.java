package org.javatx.service.impl;

import org.javatx.mapper.CarouselRepository;
import org.javatx.pojo.Carousel;
import org.javatx.pojo.FileBean;
import org.javatx.service.CarouselService;
import org.javatx.service.FileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 11:42
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    private final CarouselRepository carouselRepository;
    private final FileService fileService;

    public CarouselServiceImpl(CarouselRepository carouselRepository,FileService fileService) {
        this.carouselRepository = carouselRepository;
        this.fileService = fileService;
    }

    @Override
    public void save(Carousel carousel) {
        FileBean fileBean = fileService.findById(carousel.getImgId());
        carousel.setImgUrl(fileBean.getPath());
        carousel.setImgSize(fileBean.getSize());
        carouselRepository.save(carousel);
    }

    @Override
    public Page<Carousel> search(Carousel carousel, int page, Integer limit) {
        Sort sort = Sort.by(Sort.Direction.DESC, "modifyDate");
        PageRequest pageRequest = PageRequest.of(page, limit, sort);
        return carouselRepository.findAll(pageRequest);
    }

    @Override
    public void deleteById(Long id) {
        carouselRepository.deleteById(id);
    }

    @Override
    public List<Carousel> findAll() {
        return carouselRepository.findAll();
    }
}
