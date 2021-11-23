package com.fastcampus.bookmanager.domain;

import com.fastcampus.bookmanager.listener.Auditable;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//AuditingEntityListener 사용하면 Auditing 사용가능하게 해줌.
@EntityListeners(value = AuditingEntityListener.class)
@MappedSuperclass //자식테이블에 공통적으로 상속시켜줄 때 사용한다.
@Data
public class BaseEntity implements Auditable {

    @CreatedDate //생성일 자동생성
    //컬럼 이름의 속성을 정의할수 있다.
    @Column(columnDefinition = "datetime(6) default now(6) comment '생성시간'",nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정일 자동생성
    @Column(columnDefinition = "datetime(6) default now(6) comment '수정시간'",nullable = false,updatable = false)
    private LocalDateTime updatedAt;





}



