package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.ExaminerServiceImplAmountOutOfRange;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.ExaminerService;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final List<QuestionService> questionServiceList = new ArrayList<>();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService1,
                               @Qualifier("mathQuestionService") QuestionService questionService2) {
        this.questionServiceList.add(questionService1);
        this.questionServiceList.add(questionService2);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        validateAmount(amount);
        Set<Question> questions = new HashSet<>();

        // Random java questions and math questions
        int javaAmount;
        javaAmount = (amount <= questionServiceList.get(0).getAll().size()) ?
                random.nextInt(amount) : random.nextInt(questionServiceList.get(0).getAll().size());

        while(questions.size() < javaAmount) {
            questions.add(questionServiceList.get(0).getRandomQuestion());
        }
        while (questions.size() < amount) {
            questions.add(questionServiceList.get(1).getRandomQuestion());
        }

        return Set.copyOf(questions);
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new ExaminerServiceImplAmountOutOfRange("Amount must be greater than or equal to 1!");
        }
    }
}
