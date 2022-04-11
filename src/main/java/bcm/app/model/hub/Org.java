package bcm.app.model.hub;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "C_ORG_DIVISIONS",schema = "public")
public class Org {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codv_id;
    private String codv_code;
    private String codv_name;
}
