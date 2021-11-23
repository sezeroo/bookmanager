package com.fastcampus.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true) //상속받는 슈퍼클래스의 정보를 toString 해준다.
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Book book;
   // private Long bookId;

    private float averageReviewScore;

    private int reviewCount;

    // 생성, 수정 entity는 BaseEntity 에서 존재함.


}
