package pro.sky.java.course2.valiyev.examquestiongenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.valiyev.examquestiongenerator.domain.Question;
import pro.sky.java.course2.valiyev.examquestiongenerator.service.ExaminerService;

import java.util.Collection;

@RequestMapping("/exam")
@RestController
public class ExamController {
    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get")
    public Collection<Question> getQuestions(int amount) {
        return examinerService.getQuestions(amount);
    }
}
