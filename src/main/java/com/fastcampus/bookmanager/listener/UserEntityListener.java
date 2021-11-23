package com.fastcampus.bookmanager.listener;

import com.fastcampus.bookmanager.domain.User;
import com.fastcampus.bookmanager.domain.UserHistory;
import com.fastcampus.bookmanager.repository.UserHistoryRepository;
import com.fastcampus.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {

    @PostPersist //Persist 후에 동작.
    @PostUpdate //Update 후에 동작.
    public void postPersistAndPostUpdate(Object o){

        //userHistoryRepository 저장소를 객체로 만들어준다.
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        //User 객체는 전달받은 오브젝트 가 될거기때문에
        //강등시켜준다.
        User user = (User)o;
        UserHistory userHistory = new UserHistory();

        userHistory.setEmail(user.getEmail());
        userHistory.setName(user.getName());
        userHistory.setUser(user);
//        userHistory.setHomeAddress(user.getHomeAddress());
//        userHistory.setCompanyAddress(user.getCompanyAddress());
        //Embedded 타입으로 객체를 지정해주었다.
//        userHistory.setAddress(user.getAddress());
        userHistoryRepository.save(userHistory);
    }


}
