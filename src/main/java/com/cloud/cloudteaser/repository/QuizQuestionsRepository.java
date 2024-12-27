package com.cloud.cloudteaser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.cloudteaser.entity.QuizQuestions;

@Repository
public interface QuizQuestionsRepository extends JpaRepository<QuizQuestions, Integer> {
}
