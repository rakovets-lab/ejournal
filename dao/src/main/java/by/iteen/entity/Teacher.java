package by.iteen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "user_id")
@ToString
public class Teacher extends User {

    @Column(name = "pan", unique = true)
    @Setter
    @Getter
    private int PAN;

    @Column(name = "registration_date")
    @Setter
    @Getter
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;

    @Embedded
    @Getter
    @Setter
    private Address address;
}
