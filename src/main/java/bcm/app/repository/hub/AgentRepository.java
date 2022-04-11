package bcm.app.repository.hub;

import bcm.app.model.hub.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentRepository
        extends JpaRepository<Agent, Long> {

    @Query("SELECT a_agent_id FROM Agent where codv_id=:codv_id")
    Long getAgentByCodvId(@Param("codv_id") Long codv_id);
}
