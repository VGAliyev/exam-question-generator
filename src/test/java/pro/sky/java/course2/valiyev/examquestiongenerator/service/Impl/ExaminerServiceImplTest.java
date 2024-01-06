package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.ExaminerService;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.QuestionService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.valiyev.examquestiongenerator.Constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        javaQuestionService.add(QUESTION_1);
    }

    @Test
    void getQuestions() {
        /* ToDo */
    }

    @Test
    void getQuestionsAmountOutOfRange() {
        /* ToDo */
    }
}