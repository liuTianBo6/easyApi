package com.api.apiinterface.controller;

import com.api.sdk.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")
@Slf4j
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        return "POST 用户名字是" + user.getUsername();
        
        /*
         * String accessKey = request.getHeader("accessKey");
         *         String nonce = request.getHeader("nonce");
         *         String timestamp = request.getHeader("timestamp");
         *         String sign = request.getHeader("sign");
         *         String body = request.getHeader("body");
         *
         *         // 实际情况应该是去数据库中查是否已分配给用户（我认为在网关已经过滤了，可以不用考虑这些）
         *         if (!accessKey.equals("7ae3ffba7425028cb67f771fcf4825f8")) {
         *             throw new RuntimeException("无权限");
         *         }
         *         if (Long.parseLong(nonce) > 10000) {
         *             throw new RuntimeException("无权限");
         *         }
         *         // 和当前时间不能超过 5 分钟（我认为在网关已经过滤了，可以不用考虑这些）
         *         // 实际情况中是从数据库中查出 secretKey（我认为在网关已经过滤了，可以不用考虑这些）
         *         String serverSign = SignUtils.genSign(body, "f8995877181ee0b8dc2b9e44a3768f91");
         *         if (!sign.equals(serverSign)) {
         *             throw new RuntimeException("无权限");
         *         }
         *
         *         return "POST 用户名字是" + user.getUsername();
         */
    }
}
