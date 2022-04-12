package bcm.app.repository.hub;

import bcm.app.model.hub.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrgRepository
        extends JpaRepository<Org, Long> {

    @Query("SELECT codv_id FROM Org where codv_code=:codv_code")
    Long getCodvIdByCodvCode(@Param("codv_code") String codv_code);

    @Query("SELECT a.a_agent_id, o.codv_id, o.codv_name FROM Org o join Agent a on a.codv_id =o.codv_id where o.codv_code=:codv_code")
    List<String> getInfoByCodvCode(@Param("codv_code") String codv_code);

    @Query("SELECT a.a_agent_id FROM Org o join Agent a on a.codv_id =o.codv_id where o.codv_code=:codv_code")
    String getAgentByCodvCode(@Param("codv_code") String codv_code);
}
