package com.fastcampus.bookmanager.service;

import com.fastcampus.bookmanager.domain.User;
import com.fastcampus.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    protected UserRepository userRepository;


    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUserFastcampus.com");

        //영속화 시켜주기
        entityManager.persist(user);
//        entityManager.detach(user); // clear, close 준영속상태라고말함.

        user.setName("newUserAfterPersist");
        entityManager.merge(user);
//        entityManager.flush();
//        entityManager.clear();
        entityManager.remove(user);

    }


}
