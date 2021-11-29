package com.fastcampus.bookmanager.domain;

import com.fastcampus.bookmanager.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(UserEntityListener.class) //userHistory 테이블 데이터 저장을위한
                                           //Listener 지정해주기.
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;


    @Embedded
    //지정해놓은 속성들을 재정의해주는 어노테이션.
    //Address Embedded 를 두번사용하기때문에 DB에서 등록할때 컬럼 이름이 같은 오류발생
    //그렇기 때문에 컬럼이름을 재정의 해주어야됨.
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

    @OneToMany(fetch = FetchType.EAGER)
    //entity가 어떤컬럼으로 조인할지 지정해주는것
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude //ToString 에서 제외합니다.
    private List<Review> reviews = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Phone> phones = new ArrayList<>();
}