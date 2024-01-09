package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceAnswerNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionStringNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.repository.QuestionRepository;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.valiyev.examquestiongenerator.Constants.TestConstants.MATH_QUESTION;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;
    @InjectMocks
    private MathQuestionService mathQuestionService;

    @Test
    void shouldAddQuestionStringAnswerString() {
        when(questionRepository.add(any())).thenReturn(MATH_QUESTION);
        assertEquals(MATH_QUESTION, mathQuestionService.add("Math Question 1", "Math Answer 1"));
    }

    @Test
    void shouldAddQuestionStringNotValid() {
        assertThrows(QuestionServiceQuestionStringNullException.class, () -> mathQuestionService.add(null, "Answer"));
    }

    @Test
    void shouldAddAnswerStringNotValid() {
        assertThrows(QuestionServiceAnswerNullException.class, () -> mathQuestionService.add("Question", null));
    }

    @Test
    void shouldAddQuestion() {
        when(questionRepository.add(any())).thenReturn(MATH_QUESTION);
        assertEquals(MATH_QUESTION, mathQuestionService.add(MATH_QUESTION));
    }

    @Test
    void shouldAddQuestionNotValid() {
        assertThrows(QuestionServiceQuestionNullException.class, () -> mathQuestionService.add(null));
    }

    @Test
    void remove() {
        when(questionRepository.remove(any())).thenReturn(MATH_QUESTION);
        assertEquals(MATH_QUESTION, mathQuestionService.remove(MATH_QUESTION));
    }

    @Test
    void getAll() {
        when(questionRepository.getAll()).thenReturn(Set.of(MATH_QUESTION));
        assertEquals(Set.of(MATH_QUESTION), mathQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        when(questionRepository.getAll()).thenReturn(List.of(MATH_QUESTION));
        assertEquals(MATH_QUESTION, mathQuestionService.getRandomQuestion());
    }
}