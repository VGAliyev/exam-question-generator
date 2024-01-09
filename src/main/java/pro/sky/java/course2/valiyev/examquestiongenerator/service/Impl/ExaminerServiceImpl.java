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
    private final QuestionService questionService1;
    private final QuestionService questionService2;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService1,
                               @Qualifier("mathQuestionService") QuestionService questionService2) {
        this.questionService1 = questionService1;
        this.questionService2 = questionService2;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        validateAmount(amount);
        Set<Question> questions = new HashSet<>();

        // Random java answers and math answers
        int javaAnswer, mathAnswer;
        if (questionService1.getAll().size() > questionService2.getAll().size()) {
            mathAnswer = (amount > questionService2.getAll().size()) ? random.nextInt(questionService2.getAll().size()) : random.nextInt(amount);
            javaAnswer = Math.min((amount - mathAnswer), questionService1.getAll().size());
        } else {
            javaAnswer = (amount > questionService1.getAll().size()) ? random.nextInt(questionService1.getAll().size()) : random.nextInt(amount);
            mathAnswer = Math.min((amount - javaAnswer), questionService2.getAll().size());
        }
        //-----------------------------------------

        for (int i = 0; i < javaAnswer; i++) {
            questions.add(questionService1.getRandomQuestion());
        }
        for (int i = 0; i < mathAnswer; i++) {
            questions.add(questionService2.getRandomQuestion());
        }

        return Set.copyOf(questions);
    }

    private void validateAmount(int amount) {
        if (amount > (questionService1.getAll().size() + questionService2.getAll().size())) {
            throw new ExaminerServiceImplAmountOutOfRange("Amount should not be greater than the total number of questions!");
        }
        if (amount <= 0) {
            throw new ExaminerServiceImplAmountOutOfRange("Amount must be greater than or equal to 1!");
        }
    }
}
