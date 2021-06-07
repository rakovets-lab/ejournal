package by.iteen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "groups")
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"group", "courses"})
public class Group  extends BaseEntity {

    @Column(name = "title", unique = true)
    @Setter
    @Getter
    private String title;

    @OneToMany(mappedBy = "group")
    private Set<Child> group = new HashSet<>();

    @JoinTable(name = "groups_courses", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    @ManyToMany
    @Setter
    @Getter
    private Set<Course> courses = new HashSet<>();

}
