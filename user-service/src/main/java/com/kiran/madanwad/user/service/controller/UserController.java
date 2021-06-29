package com.kiran.madanwad.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.madanwad.user.service.entity.User;
import com.kiran.madanwad.user.service.service.UserService;
import com.kiran.madanwad.user.service.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser controller");
        return userService.saveUser(user);
    }
    
    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("inside getUserWithDepartment controller");
        return userService.getUserWithDepartment(userId);
    }
}
