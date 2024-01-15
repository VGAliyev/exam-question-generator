package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.ExaminerServiceImplAmountOutOfRange;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.QuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.valiyev.examquestiongenerator.Constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        when(questionService.getRandomQuestion()).thenReturn(JAVA_QUESTION_1);
        when(questionService.getAll()).thenReturn(QUESTIONS);
        assertIterableEquals(new HashSet<>(Set.of(JAVA_QUESTION_1)), examinerService.getQuestions(1));
    }

    @Test
    void getQuestionsAmountOutOfRange() {
        assertThrows(ExaminerServiceImplAmountOutOfRange.class, () -> examinerService.getQuestions(0));
    }
}