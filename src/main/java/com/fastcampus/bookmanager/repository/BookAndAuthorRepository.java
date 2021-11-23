package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.BookAndAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAndAuthorRepository extends JpaRepository<BookAndAuthor,Long> {


}
