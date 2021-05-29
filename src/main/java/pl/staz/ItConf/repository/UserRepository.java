package pl.staz.ItConf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.staz.ItConf.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);

}
