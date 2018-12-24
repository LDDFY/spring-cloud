package com.springcloud.feign.springcloudfeign.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    /**
     * 使用feign的默认契约，可使用feign自带注解
     *
     * @return
     */
    @Bean
    public Contract feugnClientContract() {
        return new feign.Contract.Default();
    }
}
