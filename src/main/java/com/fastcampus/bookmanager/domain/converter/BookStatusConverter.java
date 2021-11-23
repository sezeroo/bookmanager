package com.fastcampus.bookmanager.domain.converter;

import com.fastcampus.bookmanager.domain.BookStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
//컨버터 사용을 위한 어노테이션
@Converter
//AttributeConverter 를 상속받아서 사용해야한다.
public class BookStatusConverter implements AttributeConverter<BookStatus,Integer> {

    @Override //오버라이딩해서 사용 데이터베이스 컬럼으로 컨버트해준다.
    public Integer convertToDatabaseColumn(BookStatus attribute) {

//        return attribute.getCode();

        return attribute.getCode();
    }

    @Override //DB데이터를 컨버트해준다.
    public BookStatus convertToEntityAttribute(Integer dbData) {

        return dbData != null ? new BookStatus(dbData) : null;
    }

}


