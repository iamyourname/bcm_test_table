package bcm.app.model.agent;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

}
