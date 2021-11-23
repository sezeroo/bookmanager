package com.fastcampus.bookmanager.service;

import com.fastcampus.bookmanager.domain.Author;
import com.fastcampus.bookmanager.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(propagation = Propagation.NESTED)
    public void putAuthor(){
        Author author = new Author();
        author.setName("Jay");

        authorRepository.save(author);

//        throw new RuntimeException("오류가 발생하였습니다. transaction 은 어떻게 될까요? ");

    }


}
















