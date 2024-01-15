package pro.sky.java.course2.valiyev.examquestiongenerator.Constants;

import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;

import java.util.Collection;
import java.util.Set;

public class TestConstants {
    public static final Question JAVA_QUESTION_1 = new Question("Java Question 1", "Java Answer 1");
    public static final Question JAVA_QUESTION_2 = new Question("Java Question 2", "Java Answer 2");
    public static final Question MATH_QUESTION_1 = new Question("Math Question 1", "Math Answer 1");
    public static final Question MATH_QUESTION_2 = new Question("Math Question 2", "Math Answer 2");
    public static final Collection<Question> QUESTIONS = Set.of(JAVA_QUESTION_1);
}
