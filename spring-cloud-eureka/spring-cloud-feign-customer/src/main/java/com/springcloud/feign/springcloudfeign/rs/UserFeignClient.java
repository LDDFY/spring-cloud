package com.springcloud.feign.springcloudfeign.rs;

import com.springcloud.feign.springcloudfeign.config.FeignClientConfiguration;
import com.springcloud.feign.springcloudfeign.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user", configuration = FeignClientConfiguration.class)
public interface UserFeignClient {

    @RequestLine("/web/user/{id}")
    public User findUserById(@Param("id") Long id);
}
