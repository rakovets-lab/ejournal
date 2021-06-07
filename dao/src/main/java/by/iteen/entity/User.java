package by.iteen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

    @Version
    @Getter
    @Setter
    private Long version;

    @Column(name = "email")
    @Setter
    @Getter
    private String email;

    @Column(name = "password")
    @Setter
    @Getter
    private String password;

    @Column(name = "first_name")
    @Setter
    @Getter
    private String firstName;

    @Column(name = "last_name")
    @Setter
    @Getter
    private String lastName;

    @Column(name = "mobile")
    @Setter
    @Getter
    private String mobile;

    @Column(name = "role")
    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Role role;
}
