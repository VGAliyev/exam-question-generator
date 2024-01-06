package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.ExaminerServiceImplAmountOutOfRange;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.ExaminerService;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random = new Random();
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        validateAmount(amount);
        Set<Question> questionList = new HashSet<>();
        for (int i = 0; i < amount; i++) {
            questionList.add(questionService.getRandomQuestion());
        }
        return questionList;
    }

    private void validateAmount(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new ExaminerServiceImplAmountOutOfRange();
        }
    }
}
