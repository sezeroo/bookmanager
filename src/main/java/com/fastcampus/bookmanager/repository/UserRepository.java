package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    User findFirst1ByName(String name);

    User findTop1ByName(String name);

    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime time);

    List<User> findByIdAfter(Long Id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime time);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime time);

    List<User> findByCreatedAtBetween(LocalDateTime time1, LocalDateTime time2);

    List<User> findByIdBetween(Long id, Long id2);

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual (Long id1, Long id2);

    List<User> findByIdIsNotNull();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContaining(String name);

    List<User> findByNameLike(String name);

    List<User> findTop1ByNameOrderByNameDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User>findFirstByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);
    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRawRecord();

    @Query(value = "select * from user",nativeQuery = true)
    List<Map<String,Object>> findAllRawRecord();

}
