package springcloud.consumer.movie;

import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springcloud.consumer.movie.config.MyRule;

@SpringBootApplication
public class ConsumerMovieApplicationRibbon {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieApplicationRibbon.class, args);
    }

    @Bean
    @LoadBalanced //启用ribbon负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule iRule() {
        return new MyRule();
    }
}

