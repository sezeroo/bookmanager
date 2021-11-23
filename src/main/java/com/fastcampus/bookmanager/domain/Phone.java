package com.fastcampus.bookmanager.domain;

import com.fastcampus.bookmanager.domain.converter.PhoneManufacturerConverter;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
//@EntityListeners(value = PhoneEntityListener.class)
public class Phone extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer cost;


    @Convert(converter = PhoneManufacturerConverter.class)
    @NonNull
    private Manufacturer manufacturer;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;





}
