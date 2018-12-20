package springcloud.consumer.movie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.consumer.movie.entity.User;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("web/movie")
public class MovieController {
    //启用ribbon负载均衡时需要将请求路径修改为ServiceId
    private static final String SERVICE_ID = "user";
    private static final String URL = "http://" + SERVICE_ID + "/web/user/";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("user/{id}")
    public User findById(@PathVariable(name = "id") Long id) {
        log.debug("path:web/movie/user/{}", id);
        return restTemplate.getForObject(URL + id, User.class);
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        //此处serviceId为服务的名字
        return discoveryClient.getInstances("user");
    }
}
