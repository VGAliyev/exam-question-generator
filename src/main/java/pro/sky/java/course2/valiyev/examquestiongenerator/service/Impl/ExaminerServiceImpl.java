package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.ExaminerService;

import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
