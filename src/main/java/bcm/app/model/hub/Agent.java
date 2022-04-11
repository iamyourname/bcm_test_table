package bcm.app.model.hub;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "a_agents_org_divisions_rel",schema = "public")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a_agent_id;
    private Long codv_id;
    private String a_aodr_begdate;
    private String a_aodr_enddate;
}
