package com.ll.sbb;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
