package com.fastcampus.bookmanager.domain;

import com.fastcampus.bookmanager.domain.converter.BookStatusConverter;
import com.fastcampus.bookmanager.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Where(clause = "deleted = false")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    @OneToOne(mappedBy = "book")
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Publisher publisher;

    //convert 사용을 위한 어노테이션
    @Convert(converter = BookStatusConverter.class)
    @Nullable
    private BookStatus Status;

//    @ManyToMany
    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    private boolean deleted;

    public void addBookAndAuthors(BookAndAuthor... bookAndAuthor){

        if(bookAndAuthor != null){
            for(BookAndAuthor bookAndAuthors: bookAndAuthor){
                Collections.addAll(this.bookAndAuthors, bookAndAuthor);

            }
        }
    }


}
