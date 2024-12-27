package com.cloud.cloudteaser.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "authorize_mapping")
@RequiredArgsConstructor
@ToString
public class AuthorizeMapping {

    @EmbeddedId
    private AuthorizeMappingKey id;
    
    @Column(name = "max_questions")
    private int maxQuestions;
}
