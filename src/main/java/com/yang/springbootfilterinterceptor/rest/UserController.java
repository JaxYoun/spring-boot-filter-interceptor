package com.yang.springbootfilterinterceptor.rest;

import com.google.gson.Gson;
import com.yang.springbootfilterinterceptor.annotation.StatusCheck;
import com.yang.springbootfilterinterceptor.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @StatusCheck
    @PostMapping("/login")
    public String login(ServletRequest request, @RequestParam Integer id) {
        System.out.println(request.getAttribute("addedRequestParam"));
        System.out.println(id);
        return "Login success!";
    }

    @StatusCheck
    @PostMapping("/getUserById")
    public String getUserById(@RequestParam Integer id) {
        User user = User.builder().id(id).name("yang").build();
        return new Gson().toJson(user);
    }

    @PostMapping("/getAllUser")
    public String getAllUser() {
        return "100个用户！";
    }

}
