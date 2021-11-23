package com.fastcampus.bookmanager.domain.converter;

import com.fastcampus.bookmanager.domain.Manufacturer;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PhoneManufacturerConverter implements AttributeConverter<Manufacturer,Integer> {


    @Override
    public Integer convertToDatabaseColumn(Manufacturer attribute) {

        return attribute.getCode();
    }


    @Override
    public Manufacturer convertToEntityAttribute(Integer dbData) {

        return new Manufacturer(dbData);
    }



}
