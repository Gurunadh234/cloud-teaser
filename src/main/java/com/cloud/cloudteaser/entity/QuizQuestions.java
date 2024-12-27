package com.cloud.cloudteaser.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quiz_questions")
@Getter
@Setter
public class QuizQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
    private Quizzes quizzes;

    @ManyToOne
    @JoinColumn(name = "question_num", referencedColumnName = "num")
    private QuestionPool questionPool;
}
