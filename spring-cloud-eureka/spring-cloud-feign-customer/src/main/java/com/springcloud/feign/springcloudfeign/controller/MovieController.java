package com.springcloud.feign.springcloudfeign.controller;

import com.springcloud.feign.springcloudfeign.entity.User;
import com.springcloud.feign.springcloudfeign.rs.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("web/movie")
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("user/{id}")
    public User findById(@PathVariable(name = "id") Long id) {
        log.debug("method:userFeignClient path:web/movie/user/{}", id);
        return userFeignClient.findUserById(id);
    }

}
