package com.cloud.cloudteaser.service.impl;

import com.cloud.cloudteaser.dao.QuizRequest;
import com.cloud.cloudteaser.dao.QuizResponse;
import com.cloud.cloudteaser.entity.AuthorizeMapping;
import com.cloud.cloudteaser.entity.AuthorizeMappingKey;
import com.cloud.cloudteaser.entity.QuestionPool;
import com.cloud.cloudteaser.entity.QuizQuestions;
import com.cloud.cloudteaser.entity.Quizzes;
import com.cloud.cloudteaser.exception.UnexpectedException;
import com.cloud.cloudteaser.props.AppProperties;
import com.cloud.cloudteaser.repository.QuestionPoolRepository;
import com.cloud.cloudteaser.repository.QuizQuestionsRepository;
import com.cloud.cloudteaser.repository.QuizzesRepository;
import com.cloud.cloudteaser.service.AuthorizeMappingService;
import com.cloud.cloudteaser.service.CloudTeaserService;
import com.cloud.cloudteaser.validation.Validator;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Log4j2
public class CloudTeaserServiceImpl implements CloudTeaserService {

	@NonNull
	private AppProperties props;
	@NonNull
	private Validator validator;
    @NonNull
    private QuestionPoolRepository questionPoolRepo;
    @NonNull
    private QuizQuestionsRepository quizQuestionsRepository;
    @NonNull
    private QuizzesRepository quizzesRepository;
    @NonNull
    private AuthorizeMappingService authorizeMappingService;

    @Override
    public List<QuizResponse> getAllQuestions() {
        List<QuestionPool> questions = questionPoolRepo.findAll();
        List<QuizResponse> responses = mapQuizResponse(questions);
        log.info("Responses: {}", responses);
        return responses;
    }

    @Override
    public List<QuizResponse> createQuiz(QuizRequest quiz) {
    	AuthorizeMapping authorizeMapping = authorizeMappingService.authorizeCloudProviderAndExamCode(quiz.getProvider(), quiz.getExamCode());
    	
    	/** TODO Change page size to authorize max question count */
    	Pageable pageable = PageRequest.of(0, authorizeMapping.getMaxQuestions());
        List<QuestionPool> questions = questionPoolRepo.findAllByAuthorizeMapping(authorizeMapping, pageable);
        
        if(validator.validateQuestionCount(questions, authorizeMapping.getMaxQuestions())) {
        	/** TODO: Reset pageNum of specific user to zero */
        }
        
        Quizzes savedQuiz = saveQuiz(quiz, questions);
        int savedQuizQuestions = saveQuizQuestions(savedQuiz, questions);
        
        if(savedQuizQuestions != questions.size()) {
        	throw new UnexpectedException("Unexpected interruption occured, saved: %s, actual: %s".formatted(savedQuizQuestions, questions.size()));
        }
        else {
        	log.info("Successfully created quiz");
        }
        
        List<QuizResponse> responses = mapQuizResponse(questions);
        
        return responses;
    }
    
    public Quizzes saveQuiz(QuizRequest quiz, List<QuestionPool> questions) {
    	Quizzes quizzes = new Quizzes();
        quizzes.setTitle(quiz.getTitle());
        quizzes.setCreated(LocalDateTime.now());
        
        return quizzesRepository.save(quizzes);
    }
    
    public int saveQuizQuestions(Quizzes quizzes, List<QuestionPool> questions) {
    	List<QuizQuestions> quizQuestions = mapQuizQuestions(quizzes, questions);
    	return quizQuestionsRepository.saveAll(quizQuestions).size();
    }
    
    public List<QuizQuestions> mapQuizQuestions(Quizzes quizzes, List<QuestionPool> questions) {
    	List<QuizQuestions> quizQuestions = new ArrayList<>();
    	questions.forEach(question -> {
    		QuizQuestions qq = new QuizQuestions();

    		// Setting question and quizzes in quiz question
    		qq.setQuestionPool(question);
    		qq.setQuizzes(quizzes);
    		
    		// Adding quiz questions to a list
    		quizQuestions.add(qq);
    	});
    	
    	return quizQuestions;
    }
    
    public List<QuizResponse> mapQuizResponse(List<QuestionPool> questions) {
    	List<QuizResponse> responses = new ArrayList<>();
    	
    	questions.forEach(q -> {
    		QuizResponse res = new QuizResponse();
    		res.setNum(q.getNum());
    		res.setQuestion(q.getQuestion());
    		res.setMultiOption(q.isMultiOption());
    		res.setOptions(q.getOptions());
    		responses.add(res);
    	});
    	
    	return responses;
    }
    
    public AuthorizeMapping getAuthorizeMappingReq(QuizRequest req) {
    	AuthorizeMapping authMap = new AuthorizeMapping();
    	AuthorizeMappingKey authMapKey = new AuthorizeMappingKey();
    	authMapKey.setCloudProvider(req.getProvider());
    	authMapKey.setExamCode(req.getExamCode());
    	authMap.setId(authMapKey);
    	
    	return authMap;
    }
}
