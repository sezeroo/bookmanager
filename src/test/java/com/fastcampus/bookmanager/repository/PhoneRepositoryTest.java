package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.Manufacturer;
import com.fastcampus.bookmanager.domain.Phone;
import com.fastcampus.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PhoneRepositoryTest {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void PhoneListenerTest() {
        Phone phone = new Phone();

        phone.setName("아이폰 12");
        phone.setCost(12000000);
        phone.setManufacturer(new Manufacturer(200));

        Phone phone1 = new Phone();
        phone1.setName("갤럭시12");
        phone1.setCost(10000000);
        phone1.setManufacturer(new Manufacturer(300));

      phoneRepository.save(phone);
      phoneRepository.save(phone1);

      List<Phone> phones = phoneRepository.findAll();

        User user = userRepository.findByEmail("sezero@innotree.com");
        user.setPhones(phones);

        userRepository.save(user);
//        Phone phone1 = new Phone();
//        phone1.setName("갤럭시12");
//        phone1.setCode(300);
//        phone1.setCost(1000000);
//
//        phoneRepository.save(phone1);


        System.out.println(userRepository.findByEmail("sezero@innotree.com"));
    }


}