package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("Jpa 초격자 패키지");
        book.setAuthorId(1L);


        bookRepository.save(book);

        System.out.println(bookRepository.findAll());

    }

    @Test
    @Transactional
    void bookRelationTest(){
        givenBookAndReview();

        User user = userRepository.findByEmail("sezero@innotree.com");

        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher: " + user.getReviews().get(0).getBook().getPublisher());

    }
    //cascade 영속성 전이, 영속선 전이 선언한 entity 변경하면 전이받는 entity save 하지않아도 자동 저장.
    @Test
    void bookCascadeTest(){
        Book book = new Book();
        book.setName("JPA 초격차 패키지");


        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");

        book.setPublisher(publisher);
        bookRepository.save(book);

//        publisher.add(book);
//        publisherRepository.save(publisher);
        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publisher : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("슬로우캠퍼스");

        bookRepository.save(book1);

        System.out.println("publisher :" + publisherRepository.findAll());

        Book book2 = bookRepository.findById(1L).get();
//        bookRepository.delete(book2);
        //bookRepository.deleteById(1L);

        Book book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);

        bookRepository.save(book3);


        System.out.println("books : "+ bookRepository.findAll());
        System.out.println("publishers : "+ publisherRepository.findAll());
        System.out.println("book3 Publisher :  " + bookRepository.findById(1L).get().getPublisher());

    }

        @Test
        void bookRemoveCascadeTest(){
            bookRepository.deleteById(1L);

            System.out.println("books : " + bookRepository.findAll());
            System.out.println("publishers :" + publisherRepository.findAll()) ;

            bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
        }

        @Test
        void softTest(){
           bookRepository.findAll().forEach(System.out::println);
            System.out.println(bookRepository.findById(3L));

            bookRepository.findByCategoryIsNull().forEach(System.out::println);

//            bookRepository.findAllByDeletedFalse().forEach(System.out::println);
//            bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);


        }

        @Test
        void queryTest(){
            bookRepository.findAll().forEach(System.out::println);

//            System.out.println("findByCategoryIsNullAndNoneEqualsAndCreatedAtGreaterThanEqualAndUpdateAtGreaterThanEqual(\n" +
//                    ""+bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(
//                    "JPA 초격차패키지", LocalDateTime.now().minusDays(1L),LocalDateTime.now().minusDays(1L)
//            ));

//            System.out.println(bookRepository.findByNameRecently("JPA 초격차패키지",LocalDateTime.now().minusDays(1L),LocalDateTime.now().minusDays(1L)));
//
//            System.out.println(bookRepository.findBookNameAndCategory());
//
//            bookRepository.findBookNameAndCategory().forEach(b -> {
//                System.out.println(b.getName() + ":" + b.getCategory());
//            });

            bookRepository.findBookNameAndCategory(PageRequest.of(1,1)).forEach(
                    bookNameAndCategory -> System.out.println(bookNameAndCategory.getName()+ ":" + bookNameAndCategory.getCategory())
            );

            bookRepository.findBookNameAndCategory(PageRequest.of(0,1)).forEach(
                    bookNameAndCategory -> System.out.println(bookNameAndCategory.getName()+ ":" + bookNameAndCategory.getCategory())
            );

        }



        @Test
        void nativeQueryTest(){
//            bookRepository.findAll().forEach(System.out::println);
//            bookRepository.findAllCustom().forEach(System.out::println);

            List<Book> books = bookRepository.findAll();

            for(Book book : books) {
                book.setCategory("TT전문서");

            }

            bookRepository.saveAll(books);


            System.out.println(bookRepository.findAll());

            System.out.println("affected rows : " +bookRepository.updateCategory());
            bookRepository.findAllCustom().forEach(System.out::println);

            System.out.println(bookRepository.showTables());
    }

    @Test
    void converterTest(){
        bookRepository.findAll().forEach(System.out::println);

        Book book = new Book();
        book.setName("또다른 IT전문서적");
//        book.setStatus(new BookStatus(200));

        bookRepository.save(book);
       //native query 사용을 위한 메소드를 정의해주었다.
        // bookRepository.findRowRecord()
        System.out.println(bookRepository.findRowRecord().values());

       bookRepository.findAll().forEach(System.out::println);;


    }


    @Test
    void joinTest(){
        Book book = new Book();
        book.setName("Join 구문 알아보기");

        Publisher publisher =new Publisher();
        publisher.setName("패스트캠퍼스");

        book.setPublisher(publisher);

        bookRepository.save(book);

        System.out.println(">>> : " +bookRepository.findAll());


    }

    private User givenUser(){
        User user = userRepository.findByEmail("sezero@innotree.com");
        return user;
    }

    private Book givenBook(Publisher publisher){
        Book book = new Book();

        book.setName("Jpa 초격차 패키지");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }


    private void givenBookAndReview(){

        givenReview(givenUser(),givenBook(givenPublisher()));

    }

    private void givenReview(User user, Book book){
        Review review = new Review();
        review.setTitle("내 인생을 바꾼책");
        review.setContent("꼭 한번 읽어보세용");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");

        return publisherRepository.save(publisher);
    }


}
