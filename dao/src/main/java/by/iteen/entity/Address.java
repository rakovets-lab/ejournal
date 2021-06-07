package by.iteen.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "city")
    @Setter
    @Getter
    private String city;

    @Column(name = "street")
    @Setter
    @Getter
    private String street;

    @Column(name = "house")
    @Setter
    @Getter
    private String house;

    @Column(name = "apartment")
    @Setter
    @Getter
    private String apartment;
}
