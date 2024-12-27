package com.cloud.cloudteaser.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.cloudteaser.dao.QuizRequest;
import com.cloud.cloudteaser.dao.QuizResponse;
import com.cloud.cloudteaser.service.CloudTeaserService;

import java.util.List;

@RestController
@RequestMapping("/cloud")
@RequiredArgsConstructor
@Log4j2
public class CloudTeaserController {

    @NonNull
    private CloudTeaserService service;

    @GetMapping("/all")
    public ResponseEntity<List<QuizResponse>> getAllQuestions() {
    	log.info("Fetching all questions");
        return new ResponseEntity<>(service.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/quiz")
    public ResponseEntity<List<QuizResponse>> getQuizQuestions(@RequestBody QuizRequest quiz) {
    	log.info("Fetching questions for quiz");
        return new ResponseEntity<>(service.createQuiz(quiz), HttpStatus.OK);
    }
}
