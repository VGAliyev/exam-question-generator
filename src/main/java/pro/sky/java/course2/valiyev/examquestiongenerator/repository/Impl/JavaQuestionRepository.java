package pro.sky.java.course2.valiyev.examquestiongenerator.repository.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.repository.QuestionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        System.out.println("Test");
        questions.add(new Question("Java Question 1", "Java Answer 1"));
        questions.add(new Question("Java Question 2", "Java Answer 2"));
        questions.add(new Question("Java Question 3", "Java Answer 3"));
        questions.add(new Question("Java Question 4", "Java Answer 4"));
        questions.add(new Question("Java Question 5", "Java Answer 5"));
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
