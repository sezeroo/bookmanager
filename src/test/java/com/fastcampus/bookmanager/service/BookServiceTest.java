package com.fastcampus.bookmanager.service;

import com.fastcampus.bookmanager.domain.Book;
import com.fastcampus.bookmanager.repository.AuthorRepository;
import com.fastcampus.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionTest(){
        try {
            bookService.putBookAuthor();
        }catch (Exception e ){
            System.out.println(">>>" + e.getMessage());
        }
        //exception 이 터지면 transaction 도 무력화 된다.


        System.out.println("books : " + bookRepository.findAll());
        System.out.println("authors : " + authorRepository.findAll());


    }

    @Test
    void isolationTest(){
        Book book = new Book();
        book.setName("JPA 강의");

        bookRepository.save(book);

        bookService.get(1L);

        System.out.println(">>> "+ bookRepository.findAll());

    }

    @Test
    void converterError(){
        bookService.getAll();

        bookRepository.findAll().forEach(System.out::println);
    }





}