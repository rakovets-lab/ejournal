package by.iteen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "themes")
@NoArgsConstructor
@ToString
public class Theme  extends BaseEntity {

    @Column(name = "theme")
    @Setter
    @Getter
    private String theme;

    @Column(name = "homework")
    @Setter
    @Getter
    private String homework;

    @JoinColumn(name = "course_id", nullable = false)
    @ManyToOne
    @Setter
    @Getter
    private Course course;

}
