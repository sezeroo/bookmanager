package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    //@query 를 사용할때 나오는 테이블들의 이름은
    //DB의 테이블이름이 아니라 Entity 객체를 적어줘야함.
    @Query("select distinct r from Review r join fetch r.comments")
    List<Review> findAllByFetchJoin();

    //EntityGraph 사용하기.
    @EntityGraph(attributePaths = "comments")
    @Query("select r from Review r")
    List<Review> findAllByEntityGraph();




//    @EntityGraph(attributePaths = "comments")
//    List<Review> findAll();


}
