package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceAnswerNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionStringNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.repository.QuestionRepository;

import java.util.HashSet;
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
        when(questionRepository.add(any())).thenReturn(JAVA_QUESTION_1);
        assertEquals(JAVA_QUESTION_1, javaQuestionService.add("Java Question 1", "Java Answer 1"));
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
        when(questionRepository.add(any())).thenReturn(JAVA_QUESTION_1);
        assertEquals(JAVA_QUESTION_1, javaQuestionService.add(JAVA_QUESTION_1));
    }

    @Test
    void shouldAddQuestionNotValid() {
        assertThrows(QuestionServiceQuestionNullException.class, () -> javaQuestionService.add(null));
    }

    @Test
    void remove() {
        when(questionRepository.remove(any())).thenReturn(JAVA_QUESTION_1);
        assertEquals(JAVA_QUESTION_1, javaQuestionService.remove(JAVA_QUESTION_1));
    }

    @Test
    void getAll() {
        when(questionRepository.getAll()).thenReturn(Set.of(JAVA_QUESTION_1));
        assertEquals(Set.of(JAVA_QUESTION_1), javaQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        Set<Question> questions = new HashSet<>();
        int amount = 2;
        questions = Set.of(
                JAVA_QUESTION_1,
                JAVA_QUESTION_2,
                MATH_QUESTION_1,
                MATH_QUESTION_2
        );
        when(questionRepository.getAll()).thenReturn(questions);
        assertEquals(JAVA_QUESTION_1, javaQuestionService.getRandomQuestion());
    }
}