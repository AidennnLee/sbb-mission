package com.ll.sbb;

import com.ll.sbb.answer.Answer;
import com.ll.sbb.question.Question;
import com.ll.sbb.question.QuestionRepository;
import com.ll.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionService questionService;

    //@Transactional
    @Test
    void testJpa(){
        for(int i = 1; i <= 300; i++){
            String subject = String.format("테스트 데이터 : [%03d]", i);
            String content = "테스트 데이터 내용 없음";
            this.questionService.create(subject, content);
        }

    }
}