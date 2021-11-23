package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.Book;
import com.fastcampus.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewRepositoryTest {

    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test

    void crud(){
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);
        bookReviewInfo.setBook(new Book());
        bookReviewRepository.save(bookReviewInfo);

        System.out.println("bookReviewInfo : " + bookReviewInfo);

    }

    @Test
    void crudTest2(){

        givenBookReview();

        //optional 오류일때는 orElseThrow 사용해보자
        //어짜피 테스트에서 없으면 오류나는거니까.
        Book result =   bookReviewRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBook();

        System.out.println("result :" + result);

        BookReviewInfo result2 = bookRepository.findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println(">>> "+ result2) ;

    }


    private Book givenBook(){
        Book book = new Book();
        book.setName("jpa 초격차 패키지");
        book.setAuthorId(1L);

        bookRepository.save(book);

        System.out.println(">>> " + bookRepository.findAll());

        return book;
    }

    private void givenBookReview(){
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewRepository.findAll());

    }

}