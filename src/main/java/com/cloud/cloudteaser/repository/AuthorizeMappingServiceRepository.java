package com.cloud.cloudteaser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.cloudteaser.dao.CloudProvider;
import com.cloud.cloudteaser.dao.ExamCode;
import com.cloud.cloudteaser.entity.AuthorizeMapping;
import com.cloud.cloudteaser.entity.AuthorizeMappingKey;

@Repository
public interface AuthorizeMappingServiceRepository extends JpaRepository<AuthorizeMapping, AuthorizeMappingKey>{
	Optional<AuthorizeMapping> findFirstByIdCloudProviderAndIdExamCode(CloudProvider provider, ExamCode examCode);
}
