package bcm.app.repository.agent02;

import bcm.app.model.agent02.Bout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoutRepository extends JpaRepository<Bout, Long> {

    @Query("SELECT bout_transactionid,bout_transactiondate, bout_waybillnumber, doc_status FROM  Bout where codv_id=:codv_id and bout_transactionid=:bufer")
    List<String> getBuferInfoFromAgent(@Param("codv_id") Long codv_id, @Param("bufer") String bufer);


}
