package bcm.app.repository.agent;

import bcm.app.model.agent.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository
        extends JpaRepository<User, Long>{

}