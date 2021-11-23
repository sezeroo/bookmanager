package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReviewInfo,Long> {




}
