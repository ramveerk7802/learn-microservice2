package com.quiz.QuizeService.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "quizes")
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    transient List<Question> questionList;
}
