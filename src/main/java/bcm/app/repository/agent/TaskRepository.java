package bcm.app.repository.agent;


import bcm.app.model.agent.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TaskRepository
        extends JpaRepository<Task, Long>{

}
