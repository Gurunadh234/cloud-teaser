package com.cloud.cloudteaser.dao;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuizResponse {
	private int num;
	private String question;
	private List<String> options;
	private boolean isMultiOption;
}
