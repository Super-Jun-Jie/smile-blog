package org.javatx.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author: 胡俊杰
 * @Date: 2020/11/27 15:12
 */
@RestController
public class VueTestController {

    @PostMapping("/api/login")
    public String apilogin(@RequestBody Map<String,String> param){
        return param.get("userName")+"---"+param.get("passWord");
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> param){
        return param.get("userName")+"---"+param.get("passWord");
    }
}
