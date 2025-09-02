package com.quiz.QuizeService.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Question {

    private Long id;

    private String question;

    private Long quizId;
}

