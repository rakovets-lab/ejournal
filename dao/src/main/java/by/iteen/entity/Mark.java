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
@Table(name = "marks")
@NoArgsConstructor
@ToString
public class Mark  extends BaseEntity {
    @Column(name = "marking_date")
    @Setter
    @Getter
    private LocalDate markingDate;

    @Column(name = "mark")
    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Evaluation mark;

    @ManyToMany(mappedBy = "marks")
    private Set<Child> children = new HashSet<>();
}
