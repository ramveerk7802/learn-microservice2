package com.quiz.QuizeService.services.impl;

import com.quiz.QuizeService.entities.Quiz;
import com.quiz.QuizeService.repositories.QuizRepository;
import com.quiz.QuizeService.services.QuestionClient;
import com.quiz.QuizeService.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {


    private final QuizRepository quizRepository;

    private final QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz addQuiz(Quiz q) {
        return quizRepository.save(q);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> quizListWithQuestion= quizzes.stream().map(quiz -> {
            quiz.setQuestionList(questionClient.getAllQuestionByQuiz(quiz.getId()));
            return quiz;
        }).toList();
        return quizListWithQuestion;
    }

    @Override
    public Quiz getQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found with id : "+id));

        quiz.setQuestionList(questionClient.getAllQuestionByQuiz(quiz.getId()));
        return quiz;
    }
}
