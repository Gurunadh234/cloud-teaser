package com.cloud.cloudteaser.entity;

import com.cloud.cloudteaser.dao.CloudProvider;
import com.cloud.cloudteaser.dao.ExamCode;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class AuthorizeMappingKey {
	
	@Column(name = "cloud_provider")
	@Enumerated(EnumType.STRING)
	private CloudProvider cloudProvider;
	
	@Column(name = "exam_code")
	@Enumerated(EnumType.STRING)
	private ExamCode examCode;
}
