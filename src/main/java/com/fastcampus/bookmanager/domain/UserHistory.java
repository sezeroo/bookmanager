package com.fastcampus.bookmanager.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Embedded
    //지정해놓은 속성들을 재정의해주는 어노테이션.
    @AttributeOverrides({
            @AttributeOverride(name = "city",column = @Column(name = "home_city")),
            @AttributeOverride(name = "district",column = @Column(name = "home_district")),
            @AttributeOverride(name = "detail",column = @Column(name = "home_detail")),
            @AttributeOverride(name = "zipCode",column = @Column(name = "home_zipcode"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",column = @Column(name = "company_city")),
            @AttributeOverride(name = "district",column = @Column(name = "company_district")),
            @AttributeOverride(name = "detail",column = @Column(name = "company_detail")),
            @AttributeOverride(name = "zipCode",column = @Column(name = "company_zipcode"))
    })
    private Address companyAddress;

    @ManyToOne
    @ToString.Exclude
    private User user;


}
