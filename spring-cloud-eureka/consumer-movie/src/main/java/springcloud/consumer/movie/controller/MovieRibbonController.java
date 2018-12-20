package springcloud.consumer.movie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("web/movie")
public class MovieRibbonController {

    //启用ribbon负载均衡时需要将请求路径修改为ServiceId
    private static final String SERVICE_ID = "user";
    private static final String URL = "http://" + SERVICE_ID + "/web/user/";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("log/instance")
    public void logUserInstance() {
        ServiceInstance instance = loadBalancerClient.choose(SERVICE_ID);
        log.error("serviceId:{},host:{},port:{}", instance.getServiceId(), instance.getHost(), instance.getPort());
    }

}
