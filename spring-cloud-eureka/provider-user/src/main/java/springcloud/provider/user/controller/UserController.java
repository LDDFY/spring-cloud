package springcloud.provider.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.provider.user.entity.User;
import springcloud.provider.user.repository.UserDao;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/web/user/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("{id}")
    public User getUserById(@PathVariable(name = "id") Long id) {
        log.debug("path:web/user/{}", id);
        Optional<User> user = userDao.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }
}
