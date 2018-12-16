package springcloud.consumer.movie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.consumer.movie.entity.User;

@Slf4j
@RestController
@RequestMapping("web/movie")
public class MovieController {

    private static final String URL = "http://localhost:8080/web/user/";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user/{id}")
    public User findById(@PathVariable(name = "id") Long id) {
        log.debug("path:web/movie/user/{}", id);
        return restTemplate.getForObject(URL + id, User.class);
    }
}
