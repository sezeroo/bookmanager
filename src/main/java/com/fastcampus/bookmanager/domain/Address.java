package com.fastcampus.bookmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Embeddable//Embedded 클래스 설정.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String city; // 시

    private String district; // 도

    //상세하게 이름을 설정해주자.
    @Column(name = "address_detail")
    private String detail; // 상세주소

    private String zipCode; //우편번호


}



