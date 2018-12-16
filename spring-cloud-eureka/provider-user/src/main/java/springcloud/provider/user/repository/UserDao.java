package springcloud.provider.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springcloud.provider.user.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
