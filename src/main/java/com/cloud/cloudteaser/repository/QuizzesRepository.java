package com.cloud.cloudteaser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.cloudteaser.entity.Quizzes;

@Repository
public interface QuizzesRepository extends JpaRepository<Quizzes, Integer> {
}
