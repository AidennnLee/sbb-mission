package com.ll.sbb;

import com.ll.sbb.answer.Answer;
import com.ll.sbb.question.Question;
import com.ll.sbb.question.QuestionRepository;
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
    private QuestionRepository questionRepository;

    //@Transactional
    @Test
    void testJpa(){
        Question q1 = new Question();
        q1.setSubject("스프링부트 모델 질문입니다.");
        q1.setContent("id는 자동으로 생성되나요?");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 두번째 질문 저장
/*
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
*/
        //assertEquals(기대값, 실제값) : 기대값과 실제값이 일치하는지 테스트
        //assertTrue(값) : 값이 true인지 테스트

    }
}