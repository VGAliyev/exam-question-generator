package pro.sky.java.course2.valiyev.examquestiongenerator.service;

import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;

import java.util.Collection;

public interface QuestionService {
    public Question add(String question, String answer);
    public Question add(Question question);
    public Question remove(Question question);
    public Collection<Question> getAll();
    public Question getRandomQuestion();
}
