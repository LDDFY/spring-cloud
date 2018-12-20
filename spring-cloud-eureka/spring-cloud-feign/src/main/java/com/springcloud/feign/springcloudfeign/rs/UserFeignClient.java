package com.springcloud.feign.springcloudfeign.rs;

import com.springcloud.feign.springcloudfeign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserFeignClient {

    @GetMapping("/web/user/{id}")
    public User findUserById(@PathVariable(name = "id") Long id);
}
