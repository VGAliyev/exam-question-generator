package pro.sky.java.course2.valiyev.examquestiongenerator.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.QuestionService;

import java.util.Collection;

@RequestMapping("/exam/math")
@RestController
public class MathQuestionController {
    QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        Question q = new Question(question, answer);
        questionService.add(q);
        return q;
    }

    @GetMapping("/")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question q = new Question(question, answer);
        questionService.remove(q);
        return q;
    }
}
