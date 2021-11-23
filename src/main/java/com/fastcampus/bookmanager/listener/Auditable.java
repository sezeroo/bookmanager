package com.fastcampus.bookmanager.listener;

import java.time.LocalDateTime;

//생성,수정일 기본 인터페이스 생성.
public interface Auditable {

     LocalDateTime getCreatedAt();
     LocalDateTime getUpdatedAt();

    void setCreatedAt(LocalDateTime createdAt);
    void setUpdatedAt(LocalDateTime updatedAt);


}
