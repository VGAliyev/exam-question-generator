package pro.sky.java.course2.valiyev.examquestiongenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.QuestionService;

import java.util.Collection;

@RequestMapping("/exam")
@RestController
public class JavaQuestionController {
    QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java/add")
    public Question addQuestion(String question, String answer) {
        Question q = new Question(question, answer);
        questionService.add(q);
        return q;
    }

    @GetMapping("/java/get-all")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(String question, String answer) {
        Question q = new Question(question, answer);
        questionService.remove(q);
        return q;
    }
}
