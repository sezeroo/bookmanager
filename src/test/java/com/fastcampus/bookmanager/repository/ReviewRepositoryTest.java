package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest(){
//        List<Review> reviews = reviewRepository.findAll();

        List<Review> reviews = reviewRepository.findAllByEntityGraph();

        System.out.println(reviews);

        System.out.println("전체를가져왔습니다.");

    }

//        List<Review> reviews = reviewRepository.findAllByFetchJoin();

//        List<Review> reviews =reviewRepository.findAllByEntityGraph();

//        List<Review> reviews = reviewRepository.findAll();

}

