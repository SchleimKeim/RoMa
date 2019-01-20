package ch.zhaw.roma.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AUTHORS")
@Access(AccessType.FIELD)
public class AuthorModel {
    @Id
    @Column(name = "AUTHOR_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastnName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "BIRTHDAY")
    private Date birthdsay;
    @Column(name = "STREET1")
    private String street1;
    @Column(name = "STREET2")
    private String street2;
    @Column(name = "ZIPCODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "PHONE")
    private String phone;
}
