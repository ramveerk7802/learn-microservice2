package com.quiz.QuizeService.controllers;

import com.quiz.QuizeService.entities.Quiz;
import com.quiz.QuizeService.services.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        return ResponseEntity.ok(quizService.getAllQuiz());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id){
        return ResponseEntity.ok(quizService.getQuiz(id));
    }

    @PostMapping
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz q){
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.addQuiz(q));
    }
}
