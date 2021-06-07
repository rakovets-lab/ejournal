package by.iteen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@ToString(exclude = "themes")
public class Course  extends BaseEntity {

    @Column(name = "title", unique = true)
    @Setter
    @Getter
    private String title;

    @OneToMany(mappedBy = "course")
    @Setter
    @Getter
    private Set<Theme> themes = new HashSet<>();

    @ManyToMany(mappedBy = "courses")
    @Setter
    @Getter
    private Set<Group> groups = new HashSet<>();
}
