package com.cloud.cloudteaser.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cloud.cloudteaser.dao.CloudProvider;
import com.cloud.cloudteaser.dao.ExamCode;
import com.cloud.cloudteaser.entity.AuthorizeMapping;
import com.cloud.cloudteaser.entity.AuthorizeMappingKey;
import com.cloud.cloudteaser.exception.ValidationException;
import com.cloud.cloudteaser.repository.AuthorizeMappingServiceRepository;
import com.cloud.cloudteaser.service.AuthorizeMappingService;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Getter
@Setter
@Service
@RequiredArgsConstructor
@Log4j2
public class AuthorizeMappingServiceImpl implements AuthorizeMappingService{
	
	@NonNull
	private AuthorizeMappingServiceRepository authorizeMappingServiceRepository;
	
	@Override
	public AuthorizeMapping authorizeCloudProviderAndExamCode(CloudProvider provider, ExamCode examCode) {
		Optional<AuthorizeMapping> authorizeMappingOpt = authorizeMappingServiceRepository.findFirstByIdCloudProviderAndIdExamCode(provider, examCode);
		
		if(authorizeMappingOpt.isEmpty()) {
			log.error("Provider: {} doesn't conduct {} exam", provider, examCode);
			throw new ValidationException("Provider: %s doesn't conduct %s exam".formatted(provider, examCode));
		}
		
		return authorizeMappingOpt.get();
	}
	
	@Override
	public AuthorizeMapping authorizeCloudProviderAndExamCode(AuthorizeMappingKey authorizeMappingKey) {
		return this.authorizeCloudProviderAndExamCode(authorizeMappingKey.getCloudProvider(), authorizeMappingKey.getExamCode());
	}
}
