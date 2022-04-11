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
}
