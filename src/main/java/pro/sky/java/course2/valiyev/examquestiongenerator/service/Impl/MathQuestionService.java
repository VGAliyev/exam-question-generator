package pro.sky.java.course2.valiyev.examquestiongenerator.service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.MathQuestionServiceMethodNotAllowed;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceAnswerNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.exception.QuestionServiceQuestionStringNullException;
import pro.sky.java.course2.valiyev.examquestiongenerator.repository.QuestionRepository;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private final Random random;

    public MathQuestionService(QuestionRepository questionRepository) {
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        throw new MathQuestionServiceMethodNotAllowed("Method Not Allowed!");
    }

    @Override
    public Question add(Question question) {
        throw new MathQuestionServiceMethodNotAllowed("Method Not Allowed!");
    }

    @Override
    public Question remove(Question question) {
        throw new MathQuestionServiceMethodNotAllowed("Method Not Allowed!");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MathQuestionServiceMethodNotAllowed("Method Not Allowed!");
    }

    @Override
    public Question getRandomQuestion() {
        float a, b;
        int action;
        String question = null;
        String answer = null;
        a = random.nextFloat(0.01F, 100.0F);
        b = random.nextFloat(0.01F, 100.0F);
        action = random.nextInt(1, 4);
        answer = switch (action) {
            case 1 -> {
                question = "a + b = ";
                yield String.valueOf(a + b);
            }
            case 2 -> {
                question = "a - b = ";
                yield String.valueOf(a - b);
            }
            case 3 -> {
                question = "a * b = ";
                yield String.valueOf(a * b);
            }
            case 4 -> {
                question = "a / b = ";
                yield String.valueOf(a / b);
            }
            default -> answer;
        };
        validateQuestionString(question);
        validateAnswer(answer);
        return new Question(question, answer);
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
}
