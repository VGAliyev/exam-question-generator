package pro.sky.java.course2.valiyev.examquestiongenerator.repository.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.repository.QuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        questions.add(new Question("Math Question 1", "Math Answer 1"));
        questions.add(new Question("Math Question 2", "Math Answer 2"));
        questions.add(new Question("Math Question 3", "Math Answer 3"));
        questions.add(new Question("Math Question 4", "Math Answer 4"));
        questions.add(new Question("Math Question 5", "Math Answer 5"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }
}
