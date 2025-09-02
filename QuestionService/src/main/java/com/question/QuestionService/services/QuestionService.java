package com.question.QuestionService.services;

import com.question.QuestionService.entities.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question>  getAllQuestion();

    Question getQuestionById(Long id);

    List<Question> getQuestionByQuizId(Long quizId);
}
