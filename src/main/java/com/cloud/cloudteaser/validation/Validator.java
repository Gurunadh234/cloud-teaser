package com.cloud.cloudteaser.validation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cloud.cloudteaser.entity.QuestionPool;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Validator {
	
	public boolean validateQuestionCount(List<QuestionPool> questions, int range) {
		return questions.size() < range;
	}
}
