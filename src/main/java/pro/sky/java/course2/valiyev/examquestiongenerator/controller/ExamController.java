package pro.sky.java.course2.valiyev.examquestiongenerator.controller;

import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable(value = "amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
