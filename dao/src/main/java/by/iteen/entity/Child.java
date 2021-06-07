package by.iteen.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "children")
@PrimaryKeyJoinColumn(name = "user_id")
@ToString(callSuper = true)
public class Child extends User {

    @Column(name = "birthday")
    @Setter
    @Getter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "school")
    @Setter
    @Getter
    private String school;

    @Column(name = "class")
    @Setter
    @Getter
    private String educationClass;

    @JoinColumn(name = "contract_id", nullable = false)
    @OneToOne
    @Getter
    @Setter
    private Contract contract;

    @JoinColumn(name = "parent_id", nullable = false)
    @ManyToOne
    @Setter
    @Getter
    private Parent parent;

    @JoinColumn(name = "group_id", nullable = false)
    @ManyToOne
    @Setter
    @Getter
    private Group group;

    @JoinTable(name = "children_marks", joinColumns = @JoinColumn(name = "child_id"), inverseJoinColumns = @JoinColumn(name = "mark_id"))
    @ManyToMany
    @Getter
    @Setter
    private Set<Mark> marks= new HashSet();
}
