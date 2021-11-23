package com.fastcampus.bookmanager.service;

import com.fastcampus.bookmanager.domain.User;
import com.fastcampus.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void  entityManagerTest(){

        System.out.println(entityManager.createQuery("select  U From User U").getResultList());
    }

    @Test
    void cacheFindTest(){
//        System.out.println(userRepository.findByEmail("Jay@innotree.com"));
//        System.out.println(userRepository.findByEmail("Jay@innotree.com"));
//        System.out.println(userRepository.findByEmail("Jay@innotree.com"));
//        System.out.println(userRepository.findById(2L).get());
//        System.out.println(userRepository.findById(2L).get());
//        System.out.println(userRepository.findById(2L).get());

        userRepository.deleteById(1L);

    }

    @Test
    void cacheFindTest2(){
        User user = userRepository.findById(1L).get();
        user.setName("rose");
        userRepository.save(user);
        System.out.println("====================================");

        user.setEmail("rose@rose.com");
        userRepository.save(user);

        System.out.println(userRepository.findAll());

    }


}
