package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.MathQuestionServiceMethodNotAllowed;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.valiyev.examquestiongenerator.Constants.TestConstants.MATH_QUESTION;

class MathQuestionServiceTest {
    private MathQuestionService mathQuestionService;

    @BeforeEach
    void setUp() {
        mathQuestionService = new MathQuestionService(null);
    }

    @Test
    void shouldAddQuestionStringAnswerString() {
        assertThrows(MathQuestionServiceMethodNotAllowed.class, () -> mathQuestionService.add("Math Question 1", "Math Answer 1"));
    }

    @Test
    void shouldAddQuestion() {
        assertThrows(MathQuestionServiceMethodNotAllowed.class, () -> mathQuestionService.add(MATH_QUESTION));
    }

    @Test
    void remove() {
        assertThrows(MathQuestionServiceMethodNotAllowed.class, () -> mathQuestionService.remove(MATH_QUESTION));
    }

    @Test
    void getAll() {
        assertThrows(MathQuestionServiceMethodNotAllowed.class, () -> mathQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        assertEquals(MATH_QUESTION.getClass(), mathQuestionService.getRandomQuestion().getClass());
        assertNotNull(mathQuestionService.getRandomQuestion().getQuestion());
        assertNotNull(mathQuestionService.getRandomQuestion().getAnswer());
    }
}