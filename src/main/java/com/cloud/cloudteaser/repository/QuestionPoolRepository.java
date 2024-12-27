package com.cloud.cloudteaser.repository;


import com.cloud.cloudteaser.dao.CloudProvider;
import com.cloud.cloudteaser.dao.ExamCode;
import com.cloud.cloudteaser.entity.AuthorizeMapping;
import com.cloud.cloudteaser.entity.QuestionPool;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionPoolRepository extends JpaRepository<QuestionPool, Integer> {
    List<QuestionPool> findAllByAuthorizeMapping(AuthorizeMapping authorizeMapping);
    List<QuestionPool> findAllByAuthorizeMapping(AuthorizeMapping authorizeMapping, Pageable pageable);
}

