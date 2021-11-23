package com.fastcampus.bookmanager.service;

import com.fastcampus.bookmanager.domain.Author;
import com.fastcampus.bookmanager.domain.Book;
import com.fastcampus.bookmanager.repository.AuthorRepository;
import com.fastcampus.bookmanager.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    //autowired 해주는거랑같은기능임. 생성자주입.
    //final 이기때문에 생성자가 반드시 필요하기때문에 @RequiredArgsConstructor 사용
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;

//    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAuthor(){
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        try {
            authorService.putAuthor();
        }catch (RuntimeException e){

        }

//        throw new RuntimeException("오류가 발생하였습니다. transaction 은 어떻게 될까요? ");


//        Author author = new Author();
//        author.setName("gyuri");
//
//        authorRepository.save(author);
//

    }

//    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(Long id){



        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        entityManager.clear();

        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        bookRepository.update();

        entityManager.clear();


//        Book book = bookRepository.findById(id).get();
//        book.setName("바뀔까요?");
//        bookRepository.save(book);

    }

    @Transactional
    public List<Book> getAll(){
        List<Book> books = bookRepository.findAll();

        books.forEach(System.out::println);

        return books;
    }


}
