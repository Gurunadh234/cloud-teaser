package com.cloud.cloudteaser.service;

import com.cloud.cloudteaser.dao.CloudProvider;
import com.cloud.cloudteaser.dao.ExamCode;
import com.cloud.cloudteaser.entity.AuthorizeMapping;
import com.cloud.cloudteaser.entity.AuthorizeMappingKey;

public interface AuthorizeMappingService {
	AuthorizeMapping authorizeCloudProviderAndExamCode(CloudProvider provider, ExamCode examCode);
	AuthorizeMapping authorizeCloudProviderAndExamCode(AuthorizeMappingKey authorizeMappingKey);
}
