package com.quiz.QuizeService.services;

import com.quiz.QuizeService.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Quiz q);

    List<Quiz> getAllQuiz();

    Quiz getQuiz(Long id);
}
