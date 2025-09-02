package com.quiz.QuizeService.services;


import com.quiz.QuizeService.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082/api",value = "Question-client")

// for load balancing
@FeignClient(name = "QUESTION-SERVICE",value = "Question-client")
public interface QuestionClient {

    @GetMapping("/question/quiz/{id}")
    List<Question> getAllQuestionByQuiz(@PathVariable Long id);
}
