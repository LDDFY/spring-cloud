package springcloud.consumer.movie.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MyRule extends AbstractLoadBalancerRule {

    public Server choose(ILoadBalancer loadBalancer, Object o) {
        List<Server> serverList = loadBalancer.getAllServers();
        if (!serverList.isEmpty()) {
            Server server = serverList.get(0);
            log.error("id:{},port:{}", server.getId(), server.getHostPort());
            return server;
        }
        return null;
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
