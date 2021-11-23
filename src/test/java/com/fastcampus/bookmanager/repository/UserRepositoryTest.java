package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.Address;
import com.fastcampus.bookmanager.domain.Gender;
import com.fastcampus.bookmanager.domain.User;
import com.fastcampus.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void crud() { // create, read, update, delete

        userRepository.save(new User("david","david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);

    }

    @Test
    void select(){
//        System.out.println(userRepository.findByName("denis"));
//
//        System.out.println("findByEmail : "+ userRepository.findByEmail("sezero@innotree.com"));
//        System.out.println("getByEmail : "+ userRepository.getByEmail("sezero@innotree.com"));
//        System.out.println("readByEmail : "+ userRepository.readByEmail("sezero@innotree.com"));
//        System.out.println("queryByEmail : "+ userRepository.queryByEmail("sezero@innotree.com"));
//        System.out.println("searchByEmail : "+ userRepository.searchByEmail("sezero@innotree.com"));
//        System.out.println("streamByEmail : "+ userRepository.streamByEmail("sezero@innotree.com"));
//        System.out.println("findUserByEmail : "+ userRepository.findUserByEmail("sezero@innotree.com"));
//
//        System.out.println("findTop1ByName : " +userRepository.findTop1ByName("Jay") );
//        System.out.println("findFirst1ByName : " +userRepository.findFirst1ByName("Jay") );

//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("sezero@innotree.com","Jay"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("sezero@innotree.com","gyuri"));

        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));

        System.out.println("findByCreatedAtGreaterThan :" + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)) );
        System.out.println("findByCreatedAtGreaterThanEqual :" + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)) );

        System.out.println("findByCreatedAtBetween :" + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L),LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween :" + userRepository.findByIdBetween(1L,3L));

        System.out.println("findByIdNotNull : " + userRepository.findByIdIsNotNull());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("Jay","rose")));

        System.out.println("findByNameStartingWith :" + userRepository.findByNameStartingWith("J"));
        System.out.println("findByNameEndingWith :" + userRepository.findByNameEndingWith("a"));
        System.out.println("findByNameContains :" + userRepository.findByNameContaining("y"));

        System.out.println("findByNameLike :" + userRepository.findByNameLike("%Ja%"));


    }

    @Test
    void pagingAndSortingTest(){
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("Jay"));
        System.out.println("findTop1ByNameOrderByNameDesc : " + userRepository.findTop1ByNameOrderByNameDesc("Jay"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("Jay"));

        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("Jay", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("Jay", PageRequest.of(0,1, Sort.by(Sort.Order.desc("id")))).getContent());


        }

        @Test
        void insertAndUpdate(){

        User user = new User();
        user.setName("Jay");
        user.setEmail("sezeroo@innotree.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("Jaaaaaay");

        userRepository.save(user2);

        }

        @Test
        void enumTest(){

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        //map.get(key)
        System.out.println(userRepository.findRawRecord().get("gender"));



        }

        @Test
    void listenerTest(){
        User user=  new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("Rosy");

        userRepository.save(user2);

        userRepository.deleteById(4L);

        }

    @Test
    @Transactional
    void prePersistTest(){
        User user = new User();
        user.setEmail("martin@fastcampus.com");
        user.setName("martin");
     //   user.setCreatedAt(LocalDateTime.now());
     //   user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

//        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));

    }

    @Test
    void preUpdateTest(){
        User user = userRepository.findById(2L).orElseThrow(RuntimeException::new);

        user.setName("rosy");
        userRepository.save(user);



        System.out.println("to-be :" + userRepository.findAll().get(0));



    }

    @Test
    void userHistoryTest(){

        User user = new User();
        user.setEmail("martin@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        user.setName("martinssss");


        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

    }

    @Test
    void userRelationTest(){

        User user = new User();
        user.setName("david");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.MALE);

        userRepository.save(user);
        System.out.println(">>>" + user);

        user.setName("daniel");

        userRepository.save(user);

        user.setEmail("daniel@fastcampus.com");

        userRepository.save(user);

       this.userHistoryRepository.findAll().forEach(System.out::println);

        List<UserHistory> result = userRepository.findByEmail("daniel@fastcampus.com")
                .getUserHistories();

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser()" + userHistoryRepository.findAll().get(0).getUser());
    }


//    @Test
//    void embedTest(){
//        userRepository.findAll().forEach(System.out::println);
//
//        User user = new User();
//        user.setName("Kei");
//        user.setHomeAddress(new Address("서울시","강남구","강남대로 364 미왕빌딩","06242"));
//        user.setCompanyAddress(new Address("서울시", "성동구","성수이로 113 제강빌딩" , "04794"));
//
//        userRepository.save(user);
//
//        User user1 = new User();
//        user1.setName("sujung");
//        user1.setHomeAddress(null);
//        user1.setCompanyAddress(null);
//
//        userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setName("chayoung");
//        user2.setHomeAddress(new Address());
//        user2.setCompanyAddress(new Address()) ;
//
//        userRepository.save(user2);
//
//        entityManager.clear();
//
//        userRepository.findAll().forEach(System.out::println);
//        userHistoryRepository.findAll().forEach(System.out::println );
//
//        userRepository.findAllRawRecord().forEach(a-> System.out.println(a.values()));
//
//    }


    @Test
    void embeddedTest(){

        User user = new User();
        user.setCompanyAddress(new Address("서울특별시","을지로","파이낸스타워","123123"));
        user.setHomeAddress(new Address("서울특별시", "강남구", "강남대로", "123123"));

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

    }



    }

