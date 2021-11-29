package com.fastcampus.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)// extends 해서 BaseEntity 의 createAt, updateAt 사용하기위해서.
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate//우리가 필요한 영향을 받은 컬럼만 업데이트함
              //기존에 업데이트문을 사용하면 모든 컬럼을 업데이트함.
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @ToString.Exclude
    private Review review;

    @Column(columnDefinition = "datetime(6) default now(6)")
    private LocalDateTime commentedAt;
}

