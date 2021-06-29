package com.kiran.madanwad.user.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.kiran.madanwad.user.service.entity.User;
import com.kiran.madanwad.user.service.repository.UserReposotiory;
import com.kiran.madanwad.user.service.vo.Department;
import com.kiran.madanwad.user.service.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserReposotiory userReposotiory;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("departmentcb")
    private CircuitBreaker circuitBreaker;

    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser service");
        return userReposotiory.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment service");
        var responseTemplateVo = new ResponseTemplateVo();
        var user = userReposotiory.findByUserId(userId);
        Optional<Department> department = getDepartmentById(user.getDepartmentId());
        responseTemplateVo.setUser(user);
        if (department.isPresent()) {
            responseTemplateVo.setDepartment(department.get());
        }
        return responseTemplateVo;
    }

    public Optional<Department> getDepartmentById(Long departmentId) {
        log.info("Getting departmentById {}", departmentId);
        return circuitBreaker.run(() -> Optional.of(
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + departmentId, Department.class)),
                throwable -> getDefaultDepartment());
    }

    public Optional<Department> getDefaultDepartment() {
        log.info("Getting Default Department");
        Department department = null;
        return Optional.ofNullable(department);
    }

}
