package com.cloud.cloudteaser.service;

import java.util.List;

import com.cloud.cloudteaser.dao.QuizRequest;
import com.cloud.cloudteaser.dao.QuizResponse;

public interface CloudTeaserService {
	List<QuizResponse> getAllQuestions();
	List<QuizResponse> createQuiz(QuizRequest quizRequest);
}
