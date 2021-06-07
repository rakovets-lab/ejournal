package by.iteen.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "parents")
@PrimaryKeyJoinColumn(name = "user_id")
@ToString(callSuper = true, exclude = "children")
public class Parent extends User {

    @Embedded
    @Getter
    @Setter
    private Address address;

    @OneToMany(mappedBy = "parent")
    private Set<Child> children = new HashSet<>();

}
