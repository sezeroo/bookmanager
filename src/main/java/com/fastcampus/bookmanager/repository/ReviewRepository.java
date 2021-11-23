package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
