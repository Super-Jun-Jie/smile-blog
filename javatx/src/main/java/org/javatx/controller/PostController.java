package org.javatx.controller;

import org.javatx.pojo.wxapi.ReplyWxMsg;
import org.javatx.pojo.wxapi.SendWxMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/21 13:54
 */
@Controller
@RequestMapping("/test")
public class PostController {
//    @PostMapping(value = "/post",produces = "application/xml")
//    @ResponseBody
//    public String post(@RequestBody User user){
//        System.out.println(user.toString());
//        return "";
//    }

    @ResponseBody
    @PostMapping(value = "/post",produces = "application/xml")
    public ReplyWxMsg wxApiPost(@RequestBody SendWxMsg sendWxMsg){
        ReplyWxMsg replyWxMsg = new ReplyWxMsg();
        replyWxMsg.setContent("欢迎使用");
        replyWxMsg.setFromUserName(sendWxMsg.getToUserName());
        replyWxMsg.setToUserName(sendWxMsg.getFromUserName());
        replyWxMsg.setCreateTime(System.currentTimeMillis()+"");
        replyWxMsg.setMsgType(sendWxMsg.getMsgType());
        return replyWxMsg;
    }
}
