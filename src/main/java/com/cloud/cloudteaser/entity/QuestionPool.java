package com.cloud.cloudteaser.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
@Entity
@Table(name = "question_pool")
public class QuestionPool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private int num;

    @Embedded
    @ManyToOne
    @JoinColumns({
    		@JoinColumn(name = "cloud_provider", referencedColumnName = "cloud_provider"),
    		@JoinColumn(name = "exam_code", referencedColumnName = "exam_code")
    })
    private AuthorizeMapping authorizeMapping;
    
    @Column(name = "question")
    private String question;

    @Column(name = "options_list")
    private List<String> options;

    @Column(name = "is_multi_option")
    private boolean isMultiOption;

    @Column(name = "answer")
    private String answer;

    @Column(name = "explanation")
    private String explanation;
    
}
