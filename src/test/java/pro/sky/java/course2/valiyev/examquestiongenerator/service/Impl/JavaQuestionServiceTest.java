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
import static pro.sky.java.course2.valiyev.examquestiongenerator.Constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;
    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Test
    void shouldAddQuestionStringAnswerString() {
        when(questionRepository.add(any())).thenReturn(JAVA_QUESTION);
        assertEquals(JAVA_QUESTION, javaQuestionService.add("Java Question 1", "Java Answer 1"));
    }

    @Test
    void shouldAddQuestionStringNotValid() {
        assertThrows(QuestionServiceQuestionStringNullException.class, () -> javaQuestionService.add(null, "Answer"));
    }

    @Test
    void shouldAddAnswerStringNotValid() {
        assertThrows(QuestionServiceAnswerNullException.class, () -> javaQuestionService.add("Question", null));
    }

    @Test
    void shouldAddQuestion() {
        when(questionRepository.add(any())).thenReturn(JAVA_QUESTION);
        assertEquals(JAVA_QUESTION, javaQuestionService.add(JAVA_QUESTION));
    }

    @Test
    void shouldAddQuestionNotValid() {
        assertThrows(QuestionServiceQuestionNullException.class, () -> javaQuestionService.add(null));
    }

    @Test
    void remove() {
        when(questionRepository.remove(any())).thenReturn(JAVA_QUESTION);
        assertEquals(JAVA_QUESTION, javaQuestionService.remove(JAVA_QUESTION));
    }

    @Test
    void getAll() {
        when(questionRepository.getAll()).thenReturn(Set.of(JAVA_QUESTION));
        assertEquals(Set.of(JAVA_QUESTION), javaQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        when(questionRepository.getAll()).thenReturn(List.of(JAVA_QUESTION));
        assertEquals(JAVA_QUESTION, javaQuestionService.getRandomQuestion());
    }
}