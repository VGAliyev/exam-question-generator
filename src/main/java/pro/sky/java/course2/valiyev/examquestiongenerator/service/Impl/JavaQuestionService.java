package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceAnswerNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionStringNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.repository.QuestionRepository;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;
    private final Random random;

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        validateQuestionString(question);
        validateAnswer(answer);

        if (!question.equals(answer)) {
            Question q = new Question(question, answer);
            add(q);

            return q;
        }
        return null;
    }

    @Override
    public Question add(Question question) {
        validateQuestion(question);

        if (!question.getQuestion().equals(question.getAnswer())) {
            questionRepository.add(question);

            return question;
        }
        return null;
    }

    @Override
    public Question remove(Question question) {
        validateQuestion(question);
        questionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return questionRepository.getAll().stream().toList().get(random.nextInt(questionRepository.getAll().size()));
    }

    private void validateQuestionString(String question) {
        if (question == null) {
            throw new QuestionServiceQuestionStringNullException();
        }
    }

    private void validateAnswer(String answer) {
        if (answer == null) {
            throw new QuestionServiceAnswerNullException();
        }
    }

    private void validateQuestion(Question question) {
        if (question == null) {
            throw new QuestionServiceQuestionNullException();
        }
    }
}
