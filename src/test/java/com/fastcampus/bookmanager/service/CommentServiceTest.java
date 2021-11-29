package com.fastcampus.bookmanager.service;

import com.fastcampus.bookmanager.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void CommentTest(){
        commentService.init();

//        commentRepository.findAll().forEach(System.out::println);

        commentService.updateSumThing();
        commentService.insertSomething();

    }




}