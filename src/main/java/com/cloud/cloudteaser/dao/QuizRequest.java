package com.cloud.cloudteaser.dao;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class QuizRequest {
	private String title;
    private CloudProvider provider;
    private ExamCode examCode;
}
