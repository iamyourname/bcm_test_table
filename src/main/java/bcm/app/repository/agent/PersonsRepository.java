package bcm.app.repository.agent;

import bcm.app.model.agent.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface PersonsRepository extends JpaRepository<Person, Long> {
}
