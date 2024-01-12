package pro.sky.java.course2.valiyev.examquestiongenerator.repository;

import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    public Question add(Question question);
    public Question remove(Question question);
    public Collection<Question> getAll();
}
