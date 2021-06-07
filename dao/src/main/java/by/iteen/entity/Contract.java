package by.iteen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "contracts")
@NoArgsConstructor
@ToString(exclude = {"payments", "child"})
public class Contract extends BaseEntity {

    @Column(name = "title", unique = true)
    @Setter
    @Getter
    private String title;

    @Column(name = "availability_contract")
    @Setter
    @Getter
    private boolean availabilityContract;

    @Column(name = "availability_statements")
    @Setter
    @Getter
    private boolean availabilityStatements;

    @Column(name = "availability_birth_certificate")
    @Setter
    @Getter
    private boolean availabilityBirthCertificate;

    @Column(name = "availability_contract_photography")
    @Setter
    @Getter
    private boolean availabilityContractPhotography;

    @Column(name = "conclusion_date")
    @Setter
    @Getter
    private LocalDate conclusionDate;

    @Column(name = "expiry_date")
    @Setter
    @Getter
    private LocalDate expiryDate;

    @OneToMany(mappedBy = "contract")
    private Set<Payment> payments = new HashSet<>();

    @OneToOne(mappedBy = "contract")
    private Child child;
}
