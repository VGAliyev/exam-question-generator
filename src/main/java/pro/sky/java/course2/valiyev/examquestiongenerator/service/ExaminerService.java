package pro.sky.java.course2.valiyev.examquestiongenerator.service;

import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}
