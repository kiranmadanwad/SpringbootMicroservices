package com.kiran.madanwad.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @RequestMapping(value = "/userServiceFallBack", method = { RequestMethod.GET, RequestMethod.POST })
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." + " Please try again later";
    }

    @RequestMapping(value = "/departmentServiceFallBack", method = { RequestMethod.GET, RequestMethod.POST })
    public String departmentServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." + " Please try again later";
    }

}
