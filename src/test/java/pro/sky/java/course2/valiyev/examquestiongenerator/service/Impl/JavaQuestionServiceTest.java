package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceAnswerNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionStringNullException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.valiyev.examquestiongenerator.Constants.TestConstants.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    void setUp() {
        javaQuestionService.add(QUESTION_1);
        javaQuestionService.add(QUESTION_2);
        javaQuestionService.add(QUESTION_3);
        javaQuestionService.add(QUESTION_4);
        javaQuestionService.add(QUESTION_5);
    }

    @Test
    void shouldAddQuestionStringAnswerString() {
        assertEquals(QUESTION_6, javaQuestionService.add("Java Question 6", "Java Answer 6"));
    }

    @Test
    void shouldAddQuestionStringEqualsAnswerString() {
        assertNull(javaQuestionService.add("Java Question 7", "Java Question 7"));
    }

    @Test
    void shouldAddQuestionStringNullException() {
        assertThrows(QuestionServiceQuestionStringNullException.class, () -> javaQuestionService.add(null, "Answer"));
    }

    @Test
    void shouldAddAnswerStringNullException() {
        assertThrows(QuestionServiceAnswerNullException.class, () -> javaQuestionService.add("Question", null));
    }

    @Test
    void shouldAddQuestion() {
        assertEquals(QUESTION_6, javaQuestionService.add(QUESTION_6));
    }

    @Test
    void shouldAddQuestionEQA() {
        assertNull(javaQuestionService.add(QUESTION_EQA));
    }

    @Test
    void shouldAddQuestionNullException() {
        assertThrows(QuestionServiceQuestionNullException.class, () -> javaQuestionService.add(null));
    }

    @Test
    void remove() {
        assertEquals(QUESTION_5, javaQuestionService.remove(QUESTION_5));
    }

    @Test
    void getAll() {
        /* ToDo */
    }

    @Test
    void getRandomQuestion() {
        /* ToDo */
    }
}