package org.javatx.controller;

import org.javatx.entiy.MenuDto;
import org.javatx.result.ResultData;
import org.javatx.result.ResultEnum;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/2 9:53
 */
@Controller
@RequestMapping("menu")
public class MenuController {
    @ResponseBody
    @GetMapping(value = "userMenu",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData<MenuDto> getUserMenu(){
        List<MenuDto> menuDtoList = new ArrayList<>();

        MenuDto menuDto1 = new MenuDto(1,"文章管理","");


        MenuDto menuDto11 = new MenuDto(11,"文章列表","article");
        MenuDto menuDto12 = new MenuDto(12,"分类列表","category");

        List<MenuDto> list1 = new ArrayList<>();
        list1.add(menuDto11);
        list1.add(menuDto12);

        menuDto1.setChildren(list1);


        MenuDto menuDto2 = new MenuDto(2,"文件管理","");

        MenuDto menuDto21 = new MenuDto(21,"源码文件","file");
        MenuDto menuDto22 = new MenuDto(22,"开发工具","tools");

        List<MenuDto> list = new ArrayList<>();
        list.add(menuDto21);
        list.add(menuDto22);
        menuDto2.setChildren(list);


        menuDtoList.add(menuDto1);
        menuDtoList.add(menuDto2);

        return new ResultData<>(ResultEnum.SUCCESS,menuDtoList);
    }

    public static void main(String[] args) {
        List<MenuDto> menuDtoList = new ArrayList<>();

        MenuDto menuDto1 = new MenuDto(1,"车辆管理","vehicle");
        MenuDto menuDto2 = new MenuDto(2,"账单管理","account");

        MenuDto menuDto21 = new MenuDto(21,"北斗账单","vehicleAccount");
        MenuDto menuDto22 = new MenuDto(22,"普通账单","commonAccount");
        MenuDto menuDto23 = new MenuDto(23,"综合账单","synthesizeAccount");

        List<MenuDto> list = new ArrayList<>();
        list.add(menuDto21);
        list.add(menuDto22);
        list.add(menuDto23);
        menuDto2.setChildren(list);

        MenuDto menuDto3 = new MenuDto(3,"工单管理","vehicle");

        menuDtoList.add(menuDto1);
        menuDtoList.add(menuDto2);
        menuDtoList.add(menuDto3);

        ResultData<MenuDto> menuDtoResultData = new ResultData<>(ResultEnum.STATUS_ERROR, menuDtoList);
    }























}
