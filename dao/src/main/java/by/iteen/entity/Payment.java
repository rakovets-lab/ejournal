package by.iteen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@ToString
public class Payment extends BaseEntity{

    @Column(name = "payment_date")
    @Setter
    @Getter
    private LocalDate paymentDate;

    @Column(name = "cash")
    @Setter
    @Getter
    private double cash;

    @JoinColumn(name = "contract_id", nullable = false)
    @ManyToOne
    @Setter
    @Getter
    private Contract contract;
}
