package com.question.QuestionService.controllers;


import com.question.QuestionService.entities.Question;
import com.question.QuestionService.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question q){
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.create(q));
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestion(){
        return ResponseEntity.ok(questionService.getAllQuestion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id){
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    // get Question of Specific quiz

    @GetMapping("/quiz/{id}")
    public ResponseEntity<List<Question>> getAllQuestionOfQuiz(@PathVariable Long id){
        return ResponseEntity.ok(questionService.getQuestionByQuizId(id));
    }
}
